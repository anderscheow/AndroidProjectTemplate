package com.example.common.repository.auth_repository.remote;

import com.example.lib_data_source.model.AuthModel;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001J+\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ+\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u0006H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\bJ\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00a7@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000b\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\f"}, d2 = {"Lcom/example/common/repository/auth_repository/remote/AuthApi;", "", "login", "Lretrofit2/Response;", "Lcom/example/lib_data_source/model/AuthModel;", "userName", "", "password", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "logout", "refreshSession", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_debug"})
public abstract interface AuthApi {
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/v2/auth/login")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object login(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.lib_data_source.model.AuthModel>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "/auth/login")
    @retrofit2.http.FormUrlEncoded()
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "username")
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    @retrofit2.http.Field(value = "password")
    java.lang.String password, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.lib_data_source.model.AuthModel>> p2);
    
    @org.jetbrains.annotations.Nullable()
    @retrofit2.http.POST(value = "api/v2/auth/refresh")
    public abstract java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<com.example.lib_data_source.model.AuthModel>> p0);
}