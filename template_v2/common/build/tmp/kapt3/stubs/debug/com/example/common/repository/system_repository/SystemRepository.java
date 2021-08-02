package com.example.common.repository.system_repository;

import com.example.common.repository.BaseRepository;
import com.example.common.repository.system_repository.local.SystemLocalDataSource;
import com.example.common.repository.system_repository.remote.SystemRemoteDataSource;
import com.example.lib_data_source.constant.SystemType;
import com.example.lib_data_source.network.source.Resource;
import com.example.lib_data_source.room.entities.system.SystemModel;
import kotlinx.coroutines.flow.Flow;
import javax.inject.Inject;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\u0011\u0010\n\u001a\u00020\tH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000bJ\u001b\u0010\f\u001a\u0004\u0018\u00010\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0010J\u0018\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\u00122\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0019\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0015R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0016"}, d2 = {"Lcom/example/common/repository/system_repository/SystemRepository;", "Lcom/example/common/repository/BaseRepository;", "Lcom/example/common/repository/system_repository/ISystemRepository;", "systemRemoteDataSource", "Lcom/example/common/repository/system_repository/remote/SystemRemoteDataSource;", "systemLocalDataSource", "Lcom/example/common/repository/system_repository/local/SystemLocalDataSource;", "(Lcom/example/common/repository/system_repository/remote/SystemRemoteDataSource;Lcom/example/common/repository/system_repository/local/SystemLocalDataSource;)V", "clearPreferencesAndDatabase", "", "getBootstrappersInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSystemModelFromLocal", "Lcom/example/lib_data_source/room/entities/system/SystemModel;", "type", "Lcom/example/lib_data_source/constant/SystemType;", "(Lcom/example/lib_data_source/constant/SystemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSystemModelFromLocalAsFlow", "Lkotlinx/coroutines/flow/Flow;", "saveSystemModelToLocal", "systemModel", "(Lcom/example/lib_data_source/room/entities/system/SystemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_debug"})
public final class SystemRepository extends com.example.common.repository.BaseRepository implements com.example.common.repository.system_repository.ISystemRepository {
    private final com.example.common.repository.system_repository.remote.SystemRemoteDataSource systemRemoteDataSource = null;
    private final com.example.common.repository.system_repository.local.SystemLocalDataSource systemLocalDataSource = null;
    
    @javax.inject.Inject()
    public SystemRepository(@org.jetbrains.annotations.NotNull()
    com.example.common.repository.system_repository.remote.SystemRemoteDataSource systemRemoteDataSource, @org.jetbrains.annotations.NotNull()
    com.example.common.repository.system_repository.local.SystemLocalDataSource systemLocalDataSource) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getBootstrappersInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object getSystemModelFromLocal(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.constant.SystemType type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.lib_data_source.room.entities.system.SystemModel> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public kotlinx.coroutines.flow.Flow<com.example.lib_data_source.room.entities.system.SystemModel> getSystemModelFromLocalAsFlow(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.constant.SystemType type) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public java.lang.Object saveSystemModelToLocal(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.room.entities.system.SystemModel systemModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1) {
        return null;
    }
    
    @java.lang.Override()
    public void clearPreferencesAndDatabase() {
    }
}