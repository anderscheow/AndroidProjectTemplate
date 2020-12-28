package com.easipos.template.services

import com.easipos.template.event_bus.NotificationCount
import com.easipos.template.tools.Preference
import org.greenrobot.eventbus.EventBus

class PushNotificationService {

    var notificationCount: Int = 0
        set(value) {
            field = value

            Preference.prefNotificationCount = value
            EventBus.getDefault().post(NotificationCount(value))
        }

    fun incrementNotificationCount() {
        this.notificationCount = notificationCount + 1
    }

    fun decrementNotificationCount() {
        if (notificationCount > 0) {
            this.notificationCount = notificationCount - 1
        } else {
            this.notificationCount = 0
        }
    }

    fun resetNotificationCount() {
        notificationCount = 0
    }

//    fun reloadNotificationCount() {
//        getNotificationCountUseCase.execute(object : DefaultSingleObserver<Int>() {
//            override fun onSuccess(value: Int) {
//                notificationCount = value
//            }
//
//            override fun onError(error: Throwable) {
//                getDefaultNotificationCount()
//            }
//        }, GetNotificationCountUseCase.Params.createQuery())
//    }

//    fun viewNotification(notificationId: Long) {
//        decrementNotificationCount()
//
//        if (!Preference.prefIsGuest) {
//            UserManager.token?.let {
//                val model = ViewDismissNotificationRequestModel(notificationId)
//
//                viewNotificationUseCase.execute(object : DefaultCompletableObserver() {
//                    override fun onComplete() {
//                        reloadNotificationCount()
//                    }
//
//                    override fun onError(error: Throwable) {
//                        super.onError(error)
//                        reloadNotificationCount()
//                    }
//                }, ViewNotificationUseCase.Params.createQuery(model))
//            }
//        }
//    }

//    fun viewNotificationList(notificationId: Long) {
//        notificationCount = 0
//
//        val model = ViewDismissNotificationRequestModel(notificationId)
//
//        viewNotificationListUseCase.execute(object : DefaultCompletableObserver() {
//        }, ViewNotificationListUseCase.Params.createQuery(model))
//    }

    fun getDefaultNotificationCount() {
        notificationCount = Preference.prefNotificationCount
    }
}