package com.example.data.test.store

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.repository.CVCache
import com.example.data.store.CVCacheDataStore
import com.example.data.test.CVFactory
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.Observable
import org.junit.Test

class CVCacheDataStoreTest {

    private val cache = mock<CVCache>()
    private val store = CVCacheDataStore(cache)

    @Test
    fun getProfileCompletes() {
        stubProfileCacheGetProfile(Observable.just(listOf(CVFactory.makeProfileEntity())))
        val testObserver = store.getProfile().test()
        testObserver.assertComplete()
    }

    @Test
    fun getSkillCompletes() {
        stubProfileCacheGetSkill(Observable.just(listOf(CVFactory.makeSkillEntity())))
        val testObserver = store.getSkills().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val data = listOf(CVFactory.makeProfileEntity())
        stubProfileCacheGetProfile(Observable.just(data))
        val testObserver = store.getProfile().test()
        testObserver.assertValue(data)
    }

    @Test
    fun getSkillReturnsData() {
        val data = listOf(CVFactory.makeSkillEntity())
        stubSkillCacheGetProfile(Observable.just(data))
        val testObserver = store.getSkills().test()
        testObserver.assertValue(data)
    }

    @Test
    fun getProfileCallsCacheSource() {
        stubProfileCacheGetProfile(Observable.just(listOf(CVFactory.makeProfileEntity())))
        store.getProfile().test()
        verify(cache).getProfile()
    }

    @Test
    fun getSkillCallsCacheSource() {
        stubSkillCacheGetProfile(Observable.just(listOf(CVFactory.makeSkillEntity())))
        store.getSkills().test()
        verify(cache).getSkillS()
    }

    @Test
    fun saveProfileCompletes() {
        stubProfileCacheSaveProfile(Completable.complete())
        val testObserver = store.saveProfile(listOf(CVFactory.makeProfileEntity())).test()
        testObserver.assertComplete()
    }

    @Test
    fun saveSkillCompletes() {
        stubSkillCacheSaveSkill(Completable.complete())
        val testObserver = store.saveSkill(listOf(CVFactory.makeSkillEntity())).test()
        testObserver.assertComplete()
    }

    @Test
    fun clearProfileCompletes() {
        stubProfileClearProfile(Completable.complete())
        val testObserver = store.cleanProfile().test()
        testObserver.assertComplete()
    }

    @Test
    fun clearSkillsCompletes() {
        stubSkillClearSkill(Completable.complete())
        val testObserver = store.cleanSkills().test()
        testObserver.assertComplete()
    }

    @Test
    fun clearProfileCallCacheStore() {
        stubProfileClearProfile(Completable.complete())
        store.cleanProfile().test()
        verify(cache).clearProfile()
    }

    @Test
    fun clearSkillCallCacheStore() {
        stubSkillsClearSkill(Completable.complete())
        store.cleanSkills().test()
        verify(cache).cleanSkillS()
    }

    private fun stubProfileCacheGetProfile(observable: Observable<List<ProfileEntity>>) {
        whenever(cache.getProfile())
            .thenReturn(observable)
    }

    private fun stubSkillCacheGetProfile(observable: Observable<List<SkillEntity>>) {
        whenever(cache.getSkillS())
            .thenReturn(observable)
    }

    private fun stubProfileCacheGetSkill(observable: Observable<List<SkillEntity>>) {
        whenever(cache.getSkillS())
            .thenReturn(observable)
    }


    private fun stubProfileCacheSaveProfile(completable: Completable) {
        stubProfilesCacheSetLastCacheTime(completable)
        whenever(cache.saveProfile(any()))
            .thenReturn(completable)
    }

    private fun stubSkillCacheSaveSkill(completable: Completable) {
        stubSkillsCacheSetLastCacheTime(completable)
        whenever(cache.saveSkills(any()))
            .thenReturn(completable)
    }

    private fun stubProfilesCacheSetLastCacheTime(completable: Completable) {
        whenever(cache.setProfileLastCachedTime(any()))
            .thenReturn(completable)
    }

    private fun stubSkillsCacheSetLastCacheTime(completable: Completable) {
        whenever(cache.setSkillsLastCachedTime(any()))
            .thenReturn(completable)
    }

    private fun stubProfileClearProfile(completable: Completable) {
        whenever(cache.clearProfile())
            .thenReturn(completable)
    }

    private fun stubSkillsClearSkill(completable: Completable) {
        whenever(cache.cleanSkillS())
            .thenReturn(completable)
    }

    private fun stubSkillClearSkill(completable: Completable) {
        whenever(cache.cleanSkillS())
            .thenReturn(completable)
    }
}