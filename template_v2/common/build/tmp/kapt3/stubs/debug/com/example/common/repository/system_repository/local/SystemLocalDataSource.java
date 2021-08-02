package com.example.common.repository.system_repository.local;

import com.example.lib_data_source.constant.SystemType;
import com.example.lib_data_source.model.SystemConfigModel;
import com.example.lib_data_source.preference.IAppSharedPreference;
import com.example.lib_data_source.preference.SPKey;
import com.example.lib_data_source.room.AppDatabase;
import com.example.lib_data_source.room.entities.system.SystemModel;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00010\f2\u0006\u0010\r\u001a\u00020\u000eH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000fJ\u0016\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\f0\u00112\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\nJ\u0019\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\fH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0017"}, d2 = {"Lcom/example/common/repository/system_repository/local/SystemLocalDataSource;", "", "appDatabase", "Lcom/example/lib_data_source/room/AppDatabase;", "sharedPreference", "Lcom/example/lib_data_source/preference/IAppSharedPreference;", "(Lcom/example/lib_data_source/room/AppDatabase;Lcom/example/lib_data_source/preference/IAppSharedPreference;)V", "clearPreferencesAndDatabase", "", "getBootstrappersInfo", "Lcom/example/lib_data_source/model/SystemConfigModel;", "getSystemModel", "Lcom/example/lib_data_source/room/entities/system/SystemModel;", "type", "Lcom/example/lib_data_source/constant/SystemType;", "(Lcom/example/lib_data_source/constant/SystemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSystemModelAsFlow", "Lkotlinx/coroutines/flow/Flow;", "saveBootstrappersInfo", "systemConfigModel", "saveSystemModel", "systemModel", "(Lcom/example/lib_data_source/room/entities/system/SystemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_debug"})
public final class SystemLocalDataSource {
    private final com.example.lib_data_source.room.AppDatabase appDatabase = null;
    private final com.example.lib_data_source.preference.IAppSharedPreference sharedPreference = null;
    
    @javax.inject.Inject()
    public SystemLocalDataSource(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.room.AppDatabase appDatabase, @org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.preference.IAppSharedPreference sharedPreference) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getSystemModel(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.constant.SystemType type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.lib_data_source.room.entities.system.SystemModel> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.example.lib_data_source.room.entities.system.SystemModel> getSystemModelAsFlow(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.constant.SystemType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveSystemModel(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.room.entities.system.SystemModel systemModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    public final void saveBootstrappersInfo(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.model.SystemConfigModel systemConfigModel) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.lib_data_source.model.SystemConfigModel getBootstrappersInfo() {
        return null;
    }
    
    public final void clearPreferencesAndDatabase() {
    }
}