package com.example.data.store

import com.example.data.repository.CVDataStore
import javax.inject.Inject

open class CVDataStoreFactory @Inject constructor(
    private val cvCacheDataStore : CVCacheDataStore,
    private val cvRemoteDataStore: CVRemoteDataStore) {

    open fun getDataStore(profileCached: Boolean,
                          cacheExpired: Boolean):CVDataStore{
        return if (profileCached && !cacheExpired){
            cvCacheDataStore
        }else{
            cvRemoteDataStore
        }
    }

    open fun getCacheDataStore(): CVDataStore {
        return cvCacheDataStore
    }
}