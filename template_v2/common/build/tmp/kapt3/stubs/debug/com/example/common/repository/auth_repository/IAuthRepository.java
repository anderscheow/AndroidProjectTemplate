package com.example.common.repository.auth_repository;

import com.example.lib_data_source.model.AuthModel;
import com.example.lib_data_source.network.source.Resource;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0014\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H&J\u001d\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0011\u0010\u000b\u001a\u00020\fH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\r"}, d2 = {"Lcom/example/common/repository/auth_repository/IAuthRepository;", "", "isGuest", "", "isLoggedIn", "login", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/lib_data_source/network/source/Resource;", "Lcom/example/lib_data_source/model/AuthModel;", "logout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshSession", "", "common_debug"})
public abstract interface IAuthRepository {
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.lib_data_source.network.source.Resource<com.example.lib_data_source.model.AuthModel>> login();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.lib_data_source.network.source.Resource<com.example.lib_data_source.model.AuthModel>>> continuation);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> continuation);
    
    public abstract boolean isGuest();
    
    public abstract boolean isLoggedIn();
}