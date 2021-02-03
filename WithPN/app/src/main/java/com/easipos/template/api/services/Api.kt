package com.easipos.template.api.services

import com.easipos.template.api.ApiEndpoint
import com.easipos.template.api.misc.EmptyResponseModel
import com.easipos.template.api.misc.ResponseModel
import com.easipos.template.api.requests.BasicRequestModel
import com.easipos.template.api.requests.notification.RegisterFcmTokenRequestModel
import com.easipos.template.api.requests.notification.RemoveFcmTokenRequestModel
import com.easipos.template.api.requests.precheck.CheckVersionRequestModel
import com.easipos.template.api.requests.user.UpdateProfileRequestModel
import com.easipos.template.api.responses.user.UserInfoResponseModel
import io.reactivex.Single
import okhttp3.RequestBody
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {

    @POST(ApiEndpoint.CHECK_VERSION)
    suspend fun checkVersion(@Body body: CheckVersionRequestModel): ResponseModel<Boolean>

    @POST(ApiEndpoint.REGISTER_REMOVE_JPUSH_REG_ID)
    suspend fun registerFcmToken(@Body body: RegisterFcmTokenRequestModel): EmptyResponseModel

    @POST(ApiEndpoint.REGISTER_REMOVE_JPUSH_REG_ID)
    suspend fun removeFcmToken(@Body body: RemoveFcmTokenRequestModel): EmptyResponseModel

    @POST(ApiEndpoint.GET_USER_INFO)
    suspend fun getUserInfo(@Body body: BasicRequestModel): ResponseModel<UserInfoResponseModel>

    @POST(ApiEndpoint.UPDATE_USER_PROFILE)
    suspend fun updateUserProfile(@Body body: UpdateProfileRequestModel): EmptyResponseModel
}
