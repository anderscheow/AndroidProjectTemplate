package com.example.common.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.alibaba.android.arouter.launcher.ARouter
import com.example.common.base.activity.FoundationActivity
import com.example.common.constant.EventBusType
import com.example.common.util.ext.withActivityAs
import com.orhanobut.logger.Logger
import org.greenrobot.eventbus.EventBus

abstract class FoundationFragment(
    @LayoutRes layoutRes: Int
) : Fragment(layoutRes) {

    override fun onAttach(context: Context) {
        Logger.v("Fragment ATTACHED")
        super.onAttach(context)
        if (EventBusType.isOnAttach(getEventBusType())) {
            registerEventBus()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Logger.v("Fragment CREATED")
        super.onCreate(savedInstanceState)
        ARouter.getInstance().inject(this)
        if (EventBusType.isOnCreate(getEventBusType())) {
            registerEventBus()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Logger.v("Fragment CREATE VIEW")
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Logger.v("Fragment VIEW CREATED")
        super.onViewCreated(view, savedInstanceState)
        init(savedInstanceState)
    }

    override fun onStart() {
        Logger.v("Fragment STARTED")
        super.onStart()
        if (EventBusType.isOnStart(getEventBusType())) {
            registerEventBus()
        }
    }

    override fun onResume() {
        Logger.v("Fragment RESUMED")
        super.onResume()
        if (EventBusType.isOnResume(getEventBusType())) {
            registerEventBus()
        }
    }

    override fun onPause() {
        Logger.v("Fragment PAUSED")
        if (EventBusType.isOnResume(getEventBusType())) {
            unregisterEventBus()
        }
        super.onPause()
    }

    override fun onStop() {
        Logger.v("Fragment STOPPED")
        if (EventBusType.isOnStart(getEventBusType())) {
            unregisterEventBus()
        }
        super.onStop()
    }

    override fun onDestroy() {
        Logger.v("Fragment DESTROYED")
        if (EventBusType.isOnCreate(getEventBusType())) {
            unregisterEventBus()
        }
        super.onDestroy()
    }

    override fun onDestroyView() {
        Logger.v("Fragment VIEW DESTROYED")
        super.onDestroyView()
    }

    override fun onDetach() {
        Logger.v("Fragment DETACHED")
        if (EventBusType.isOnAttach(getEventBusType())) {
            unregisterEventBus()
        }
        super.onDetach()
    }

    /**
     *  To initialise views.
     */
    abstract fun initViews()

    /**
     *  To initialise listeners.
     */
    abstract fun initListeners()

    /**
     *  Call from {@link androidx.fragment.app.Fragment#onViewCreated} to reduce boilerplate.
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
    protected fun isLoggedIn(): Boolean =
        withActivityAs<FoundationActivity>()?.isLoggedIn() ?: false

    /**
     *  Check is guest mode.
     *
     *  @return Boolean, guest mode status.
     */
    protected fun isGuest(): Boolean = withActivityAs<FoundationActivity>()?.isGuest() ?: false

    /**
     *  Navigate to login page if is under guest mode
     *
     *  @return Boolean, guest mode status.
     */
    protected fun handleGuestControl(): Boolean =
        withActivityAs<FoundationActivity>()?.handleGuestControl() ?: false

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
