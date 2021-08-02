package com.example.common.base.paging;

import androidx.paging.ExperimentalPagingApi;
import androidx.paging.PagingState;
import androidx.paging.RemoteMediator;

@kotlin.OptIn(markerClass = {androidx.paging.ExperimentalPagingApi.class})
@kotlin.Metadata(mv = {1, 5, 1}, k = 1, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\b\b\u0001\u0010\u0003*\u00020\u0002*\u0004\b\u0002\u0010\u00042\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00030\u0005B\u0005\u00a2\u0006\u0002\u0010\u0006J\'\u0010\u0007\u001a\u0004\u0018\u00018\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\u001b\u0010\u000b\u001a\u0004\u0018\u00018\u00022\u0006\u0010\f\u001a\u00028\u0001H\u00a6@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\rJ\'\u0010\u000e\u001a\u0004\u0018\u00018\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\nJ\'\u0010\u000f\u001a\u0004\u0018\u00018\u00022\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\tH\u0084@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/common/base/paging/BaseRemoteMediator;", "Key", "", "Value", "RemoteKey", "Landroidx/paging/RemoteMediator;", "()V", "getClosestRemoteKey", "state", "Landroidx/paging/PagingState;", "(Landroidx/paging/PagingState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteKey", "data", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getRemoteKeyForFirstItem", "getRemoteKeyForLastItem", "common_debug"})
public abstract class BaseRemoteMediator<Key extends java.lang.Object, Value extends java.lang.Object, RemoteKey extends java.lang.Object> extends androidx.paging.RemoteMediator<Key, Value> {
    
    public BaseRemoteMediator() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getRemoteKey(@org.jetbrains.annotations.NotNull()
    Value data, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super RemoteKey> p1);
    
    @org.jetbrains.annotations.Nullable()
    protected final java.lang.Object getRemoteKeyForFirstItem(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<Key, Value> state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super RemoteKey> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final java.lang.Object getRemoteKeyForLastItem(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<Key, Value> state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super RemoteKey> p1) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    protected final java.lang.Object getClosestRemoteKey(@org.jetbrains.annotations.NotNull()
    androidx.paging.PagingState<Key, Value> state, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super RemoteKey> p1) {
        return null;
    }
}