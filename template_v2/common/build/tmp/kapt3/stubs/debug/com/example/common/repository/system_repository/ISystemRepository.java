package com.example.common.repository.system_repository;

import com.example.lib_data_source.constant.SystemType;
import com.example.lib_data_source.room.entities.system.SystemModel;
import kotlinx.coroutines.flow.Flow;

@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0011\u0010\u0004\u001a\u00020\u0003H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u0005J\u001b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u0018\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\f2\u0006\u0010\b\u001a\u00020\tH&J\u0019\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0007H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000f\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/common/repository/system_repository/ISystemRepository;", "", "clearPreferencesAndDatabase", "", "getBootstrappersInfo", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSystemModelFromLocal", "Lcom/example/lib_data_source/room/entities/system/SystemModel;", "type", "Lcom/example/lib_data_source/constant/SystemType;", "(Lcom/example/lib_data_source/constant/SystemType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getSystemModelFromLocalAsFlow", "Lkotlinx/coroutines/flow/Flow;", "saveSystemModelToLocal", "systemModel", "(Lcom/example/lib_data_source/room/entities/system/SystemModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_debug"})
public abstract interface ISystemRepository {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getBootstrappersInfo(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p0);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getSystemModelFromLocal(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.constant.SystemType type, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.example.lib_data_source.room.entities.system.SystemModel> p1);
    
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<com.example.lib_data_source.room.entities.system.SystemModel> getSystemModelFromLocalAsFlow(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.constant.SystemType type);
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object saveSystemModelToLocal(@org.jetbrains.annotations.NotNull()
    com.example.lib_data_source.room.entities.system.SystemModel systemModel, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> p1);
    
    public abstract void clearPreferencesAndDatabase();
}