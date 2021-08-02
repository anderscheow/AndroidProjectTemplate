package com.example.common.repository.auth_repository;

import com.example.common.repository.BaseRepository;
import com.example.common.repository.auth_repository.local.AuthLocalDataSource;
import com.example.common.repository.auth_repository.remote.AuthRemoteDataSource;
import com.example.lib_data_source.model.AuthModel;
import com.example.lib_data_source.network.source.Resource;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0002J\b\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\f\u001a\u00020\u000bH\u0016J\u0014\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0016J\u001d\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0011\u0010\u0013\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0012J\u0010\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u0010H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/common/repository/auth_repository/AuthRepository;", "Lcom/example/common/repository/BaseRepository;", "Lcom/example/common/repository/auth_repository/IAuthRepository;", "authRemoteDataSource", "Lcom/example/common/repository/auth_repository/remote/AuthRemoteDataSource;", "authLocalDataSource", "Lcom/example/common/repository/auth_repository/local/AuthLocalDataSource;", "(Lcom/example/common/repository/auth_repository/remote/AuthRemoteDataSource;Lcom/example/common/repository/auth_repository/local/AuthLocalDataSource;)V", "clearAuthModel", "", "isGuest", "", "isLoggedIn", "login", "Lkotlinx/coroutines/flow/Flow;", "Lcom/example/lib_data_source/network/source/Resource;", "Lcom/example/lib_data_source/model/AuthModel;", "logout", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshSession", "saveAuthModel", "authModel", "common_debug"})
public final class AuthRepository extends com.example.common.repository.BaseRepository implements com.example.common.repository.auth_repository.IAuthRepository {
    private final com.example.common.repository.auth_repository.remote.AuthRemoteDataSource authRemoteDataSource = null;
    private final com.example.common.repository.auth_repository.local.AuthLocalDataSource authLocalDataSource = null;
    
    @javax.inject.Inject()
    public AuthRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.auth_repository.remote.AuthRemoteDataSource authRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.common.repository.auth_repository.local.AuthLocalDataSource authLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.example.lib_data_source.network.source.Resource<com.example.lib_data_source.model.AuthModel>> login() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object logout(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlinx.coroutines.flow.Flow<? extends com.example.lib_data_source.network.source.Resource<com.example.lib_data_source.model.AuthModel>>> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object refreshSession(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @java.lang.Override()
    public boolean isGuest() {
        return false;
    }
    
    @java.lang.Override()
    public boolean isLoggedIn() {
        return false;
    }
    
    private final void saveAuthModel(com.example.lib_data_source.model.AuthModel authModel) {
    }
    
    private final void clearAuthModel() {
    }
}