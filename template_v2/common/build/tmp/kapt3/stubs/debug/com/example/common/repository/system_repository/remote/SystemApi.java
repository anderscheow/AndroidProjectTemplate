package com.example.common.repository.system_repository.remote;

import com.example.lib_data_source.model.SystemConfigModel;
import retrofit2.Response;
import retrofit2.http.GET;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0006"}, d2 = {"Lcom/example/common/repository/system_repository/remote/SystemApi;", "", "getBootstrappersInfo", "Lretrofit2/Response;", "Lcom/example/lib_data_source/model/SystemConfigModel;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_debug"})
public abstract interface SystemApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.GET(value = "api/v2/bootstrappers")
    public abstract java.lang.Object getBootstrappersInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.lib_data_source.model.SystemConfigModel>> continuation);
}