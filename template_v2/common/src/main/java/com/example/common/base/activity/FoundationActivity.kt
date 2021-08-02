package com.example.common.base.activity

import android.os.Bundle
import android.view.View
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.constant.EventBusType
import com.example.common.repository.auth_repository.IAuthRepository
import com.orhanobut.logger.Logger
import org.greenrobot.eventbus.EventBus
import javax.inject.Inject

abstract class FoundationActivity : AppCompatActivity() {

    @Inject
    lateinit var authRepository: IAuthRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.v("Activity CREATED")
        super.onCreate(savedInstanceState)
        if (EventBusType.isOnCreate(getEventBusType())) {
            registerEventBus()
        }
        ARouter.getInstance().inject(this)
        setContentView(getViewBinding())
        init(savedInstanceState)
    }

    override fun onStart() {
        Logger.v("Activity STARTED")
        super.onStart()
        if (EventBusType.isOnStart(getEventBusType())) {
            registerEventBus()
        }
    }

    override fun onResume() {
        Logger.v("Activity RESUMED")
        super.onResume()
        if (EventBusType.isOnResume(getEventBusType())) {
            registerEventBus()
        }
    }

    override fun onPause() {
        Logger.v("Activity PAUSED")
        if (EventBusType.isOnResume(getEventBusType())) {
            unregisterEventBus()
        }
        super.onPause()
    }

    override fun onStop() {
        Logger.v("Activity STOPPED")
        if (EventBusType.isOnCreate(getEventBusType())) {
            unregisterEventBus()
        }
        super.onStop()
    }

    override fun onDestroy() {
        Logger.v("Activity DESTROYED")
        if (EventBusType.isOnCreate(getEventBusType())) {
            unregisterEventBus()
        }
        super.onDestroy()
    }

    /**
     *  Setup and return the view from ViewBinding.
     *
     *  @return View from ViewBinding.
     */
    abstract fun getViewBinding(): View

    /**
     *  To initialise views.
     */
    abstract fun initViews()

    /**
     *  To initialise listeners.
     */
    abstract fun initListeners()

    /**
     *  Call from {@link androidx.appcompat.app.AppCompatActivity#onCreate} to reduce boilerplate.
     */
    @CallSuper
    open fun init(savedInstanceState: Bundle?) {
        initActivityResultLauncher()
        initViews()
        initListeners()
    }

    /**
     *  To initialise activity result launcher.
     */
    open fun initActivityResultLauncher() = Unit

    /**
     *  Used to establish EventBus in target lifecycle.
     *
     *  @return EventBusType, or null if does not needed.
     */
    open fun getEventBusType(): EventBusType? = null

    /**
     *  Check is logged in with user.
     *
     *  @return Boolean, logged in status.
     */
    fun isLoggedIn(): Boolean = authRepository.isLoggedIn()

    /**
     *  Check is guest mode.
     *
     *  @return Boolean, guest mode status.
     */
    fun isGuest(): Boolean = authRepository.isGuest()

    /**
     *  Navigate to login page if is under guest mode
     *
     *  @return Boolean, guest mode status.
     */
    fun handleGuestControl(): Boolean {
        return isGuest()
    }

    /**
     *  Register EventBus if not registered.
     */
    private fun registerEventBus() {
        if (EventBus.getDefault().isRegistered(this).not()) {
            EventBus.getDefault().register(this)
        }
    }

    /**
     *  Unregister EventBus if registered.
     */
    private fun unregisterEventBus() {
        if (EventBus.getDefault().isRegistered(this)) {
            EventBus.getDefault().unregister(this)
        }
    }
}
