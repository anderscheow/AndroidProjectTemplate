package com.example.common.di;

import android.app.Application;
import androidx.work.WorkManager;
import com.example.common.repository.auth_repository.AuthRepository;
import com.example.common.repository.auth_repository.IAuthRepository;
import com.example.common.repository.auth_repository.remote.AuthApi;
import com.example.common.repository.system_repository.ISystemRepository;
import com.example.common.repository.system_repository.SystemRepository;
import com.example.common.repository.system_repository.remote.SystemApi;
import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;
import retrofit2.Retrofit;
import javax.inject.Singleton;

@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013H\u0007\u00a8\u0006\u0014"}, d2 = {"Lcom/example/common/di/AppModule;", "", "()V", "provideAuthApi", "Lcom/example/common/repository/auth_repository/remote/AuthApi;", "retrofit", "Lretrofit2/Retrofit;", "provideAuthRepository", "Lcom/example/common/repository/auth_repository/IAuthRepository;", "repository", "Lcom/example/common/repository/auth_repository/AuthRepository;", "provideSystemApi", "Lcom/example/common/repository/system_repository/remote/SystemApi;", "provideSystemRepository", "Lcom/example/common/repository/system_repository/ISystemRepository;", "Lcom/example/common/repository/system_repository/SystemRepository;", "provideWorkManager", "Landroidx/work/WorkManager;", "application", "Landroid/app/Application;", "common_debug"})
@dagger.Module()
public final class AppModule {
    
    public AppModule() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.common.repository.system_repository.remote.SystemApi provideSystemApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.common.repository.auth_repository.remote.AuthApi provideAuthApi(@org.jetbrains.annotations.NotNull()
    retrofit2.Retrofit retrofit) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.common.repository.auth_repository.IAuthRepository provideAuthRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.auth_repository.AuthRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final com.example.common.repository.system_repository.ISystemRepository provideSystemRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.system_repository.SystemRepository repository) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @javax.inject.Singleton()
    @dagger.Provides()
    public final androidx.work.WorkManager provideWorkManager(@org.jetbrains.annotations.NotNull()
    android.app.Application application) {
        return null;
    }
}