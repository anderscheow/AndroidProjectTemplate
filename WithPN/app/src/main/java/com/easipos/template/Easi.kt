package com.easipos.template

import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContextWrapper
import android.os.Build
import android.os.Bundle
import androidx.core.app.TaskStackBuilder
import androidx.lifecycle.LifecycleObserver
import com.easipos.template.activities.main.MainActivity
import com.easipos.template.activities.splash.SplashActivity
import com.easipos.template.di.modules.*
import com.easipos.template.managers.PushNotificationManager
import com.easipos.template.managers.UserManager
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.onesignal.OneSignal
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger
import com.orhanobut.logger.PrettyFormatStrategy
import com.pixplicity.easyprefs.library.Prefs
import io.github.anderscheow.library.CustomApplication
import org.kodein.di.DI
import org.kodein.di.instance

class Easi : CustomApplication(), LifecycleObserver {

    companion object {
        val UA = "Android/" + BuildConfig.FLAVOR + BuildConfig.VERSION_CODE + "_" + BuildConfig.BUILD_TYPE +
                " (" +
                Build.MANUFACTURER + " " +
                Build.MODEL + " " +
                Build.VERSION.RELEASE + " " +
                Build.VERSION_CODES::class.java.fields[Build.VERSION.SDK_INT].name +
                ")"
        const val API_ENDPOINT = BuildConfig.API_DOMAIN
        const val API_AUTHORISATION = ""
        const val DATABASE_NAME = "hualala-room"

        var activities = ArrayList<Activity>()

        var isActivityVisible = false

        @SuppressLint("StaticFieldLeak")
        var instance: Easi? = null
    }

    // Use to generate in-app notification
    var currentActivity: Activity? = null

    // Use mainActivity to refresh contents
    var mainActivity: MainActivity? = null
        private set

    override fun getCommonModule(): DI.Module = CommonModule(this).provideModule()

    override fun getActivityModule(): DI.Module = ActivityModule().provideModule()

    override fun getFragmentModule(): DI.Module = FragmentModule().provideModule()

    override fun importAdditionalModule(builder: DI.MainBuilder) {
        builder.apply {
            import(ApiModule(UA, API_ENDPOINT, API_AUTHORISATION).provideModule())
            import(DatabaseModule(this@Easi, DATABASE_NAME).provideModule())
        }
    }

    override fun onCreate() {
        super.onCreate()
        instance = this

        setupConfiguration()
    }

    fun logout() {
        UserManager.token = null
    }

    fun restartAndGotoOnboarding() {
        Logger.d("restartAndGotoOnboarding")
        logout()
        TaskStackBuilder.create(this)
            .addNextIntentWithParentStack(SplashActivity.newIntent(this, true))
            .startActivities()
    }

    private fun setupLifecycleCallback() {
        registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityPaused(activity: Activity) {
            }

            override fun onActivityResumed(activity: Activity) {
                isActivityVisible = true
                currentActivity = activity
            }

            override fun onActivityStarted(activity: Activity) {
            }

            override fun onActivityDestroyed(activity: Activity) {
                activities.remove(activity)
                if (activity is MainActivity) {
                    mainActivity = null
                }
            }

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {
            }

            override fun onActivityStopped(activity: Activity) {
            }

            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                activities.add(activity)
                if (activity is MainActivity) {
                    mainActivity = activity
                }
            }
        })
    }

    private fun setupConfiguration() {
        setupLifecycleCallback()
        setupFirebaseCrashlytics()
        setupLogger()
        setupPrefs()
        setupOneSignal()
    }

    private fun setupLogger() {
        val formatStrategy = PrettyFormatStrategy.newBuilder()
            .showThreadInfo(false)
            .build()
        Logger.addLogAdapter(object : AndroidLogAdapter(formatStrategy) {
            override fun isLoggable(priority: Int, tag: String?): Boolean {
                return BuildConfig.DEBUG
            }
        })
    }

    private fun setupFirebaseCrashlytics() {
        if (BuildConfig.DEBUG.not()) {
            FirebaseCrashlytics.getInstance().setCrashlyticsCollectionEnabled(true)
        }

        // Uncomment this line to enable and test Crashlytics on Firebase
//        delay(5000) {
//            throw Exception("Test")
//        }
    }

    private fun setupPrefs() {
        Prefs.Builder()
            .setContext(this)
            .setMode(ContextWrapper.MODE_PRIVATE)
            .setPrefsName(packageName)
            .setUseDefaultSharedPreference(true)
            .build()
    }

    private fun setupOneSignal() {
        val pushNotificationManager by di.instance<PushNotificationManager>()

        OneSignal.startInit(this)
            .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
            .unsubscribeWhenNotificationsAreDisabled(true)
            .setNotificationReceivedHandler { notification ->
                Logger.d(notification.toJSONObject())
                pushNotificationManager.receiveNotification(this, notification.payload.additionalData, isActivityVisible)
            }
            .setNotificationOpenedHandler { result ->
                Logger.d("$isActivityVisible, ${result.notification.toJSONObject()}")
                pushNotificationManager.openNotification(this, result.notification.payload?.additionalData, isActivityVisible)
            }
            .init()
    }
}
