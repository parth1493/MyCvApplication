package com.example.data.test.store

import com.example.data.store.CVCacheDataStore
import com.example.data.store.CVDataStoreFactory
import com.example.data.store.CVRemoteDataStore
import com.nhaarman.mockitokotlin2.mock
import org.junit.Assert.assertEquals
import org.junit.Test

class CVDataStoreFactoryTest {

    private val cacheStore = mock<CVCacheDataStore>()
    private val remoteStore = mock<CVRemoteDataStore>()
    private val factory = CVDataStoreFactory(cacheStore, remoteStore)

    @Test
    fun getDataStoreReturnsRemoteStoreWhenCacheExpired() {
        assertEquals(remoteStore, factory.getDataStore(true, true))
    }

    @Test
    fun getDataStoreReturnsRemoteStoreWhenProjectsNotCached() {
        assertEquals(remoteStore, factory.getDataStore(false, false))
    }

    @Test
    fun getDataStoreReturnsCacheStore() {
        assertEquals(cacheStore, factory.getDataStore(true, false))
    }

    @Test
    fun getCacheDataStoreReturnsCacheStore() {
        assertEquals(cacheStore, factory.getCacheDataStore())
    }
}