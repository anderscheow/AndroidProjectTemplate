package com.example.common.base.paging

import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingState
import androidx.paging.RemoteMediator

@OptIn(ExperimentalPagingApi::class)
abstract class BaseRemoteMediator<Key : Any, Value : Any, RemoteKey>
    : RemoteMediator<Key, Value>() {

    abstract suspend fun getRemoteKey(data: Value): RemoteKey?

    protected suspend fun getRemoteKeyForFirstItem(state: PagingState<Key, Value>): RemoteKey? {
        return state.firstItemOrNull()?.let { data ->
            getRemoteKey(data)
        }
    }

    protected suspend fun getRemoteKeyForLastItem(state: PagingState<Key, Value>): RemoteKey? {
        return state.lastItemOrNull()?.let { data ->
            getRemoteKey(data)
        }
    }

    protected suspend fun getClosestRemoteKey(state: PagingState<Key, Value>): RemoteKey? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.let { data ->
                getRemoteKey(data)
            }
        }
    }
}