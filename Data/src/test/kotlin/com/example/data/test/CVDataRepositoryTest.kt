package com.example.data.test

import com.example.data.CVDataRepository
import com.example.data.mapper.ProfileMapper
import com.example.data.mapper.SkillMapper
import com.example.data.mapper.TimeLineMapper
import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.repository.CVCache
import com.example.data.repository.CVDataStore
import com.example.data.store.CVDataStoreFactory
import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.TimeLine
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import org.junit.Before
import org.junit.Test

class CVDataRepositoryTest {
    private val mapperProfile = mock<ProfileMapper>()
    private val mapperSkill = mock<SkillMapper>()
    private val mapperTimeLine = mock<TimeLineMapper>()
    private val factory = mock<CVDataStoreFactory>()
    private val store = mock<CVDataStore>()
    private val cache = mock<CVCache>()
    private val repository = CVDataRepository(mapperProfile, mapperSkill,mapperTimeLine,cache, factory)

    @Before
    fun setup() {
        stubFactoryGetDataStore()
        stubFactoryGetCacheDataStore()
        stubIsCacheExpiredProfile(Single.just(false))
        stubIsCacheExpiredSkill(Single.just(false))
        stubIsCacheExpiredTimeLine(Single.just(false))
        stubAreProfileCached(Single.just(false))
        stubSaveProfile(Completable.complete())
        stubAreSkillCached(Single.just(false))
        stubSaveSkill(Completable.complete())
        stubAreTimeLineCached(Single.just(false))
        stubSaveTimeLine(Completable.complete())
    }

    @Test
    fun getProfileCompletes() {
        stubGetProfile(Observable.just(listOf(CVFactory.makeProfileEntity())))
        val profile = CVFactory.makeProfile()
        stubMapperProfile(profile, any())

        val testObserver = repository.getProfile().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfilesReturnsData() {
        val profileEntity = CVFactory.makeProfileEntity()
        val profile = CVFactory.makeProfile()
        stubGetProfile(Observable.just(listOf(profileEntity)))
        stubMapperProfile(profile, profileEntity)

        val testObserver = repository.getProfile().test()
        testObserver.assertValue(listOf(profile))
    }

    @Test
    fun getSkillsCompletes() {
        stubGetSkills(Observable.just(listOf(CVFactory.makeSkillEntity())))
        val skill = CVFactory.makeSkill()
        stubMapperSkill(skill, any())

        val testObserver = repository.getSkill().test()
        testObserver.assertComplete()
    }

    @Test
    fun getSkillsReturnsData() {
        val skillEntity = CVFactory.makeSkillEntity()
        val skill = CVFactory.makeSkill()
        stubGetSkills(Observable.just(listOf(skillEntity)))
        stubMapperSkill(skill, skillEntity)

        val testObserver = repository.getSkill().test()
        testObserver.assertValue(listOf(skill))
    }

    @Test
    fun getTimeLineCompletes() {
        stubGetTimeLine(Observable.just(listOf(CVFactory.makeTimeLineEntity())))
        val timeLine = CVFactory.makeTimeLine()
        stubMapperTimeLine(timeLine, any())

        val testObserver = repository.getTimeLine().test()
        testObserver.assertComplete()
    }

    @Test
    fun getTimeLineReturnsData() {
        val timeLineEntity = CVFactory.makeTimeLineEntity()
        val timeLine = CVFactory.makeTimeLine()
        stubGetTimeLine(Observable.just(listOf(timeLineEntity)))
        stubMapperTimeLine(timeLine, timeLineEntity)

        val testObserver = repository.getTimeLine().test()
        testObserver.assertValue(listOf(timeLine))
    }

    private fun stubFactoryGetDataStore() {
        whenever(factory.getDataStore(any(), any()))
            .thenReturn(store)
    }

    private fun stubFactoryGetCacheDataStore() {
        whenever(factory.getCacheDataStore())
            .thenReturn(store)
    }

    private fun stubIsCacheExpiredProfile(single: Single<Boolean>) {
        whenever(cache.isProfileCachedExpired())
            .thenReturn(single)
    }

    private fun stubAreProfileCached(single: Single<Boolean>) {
        whenever(cache.isProfileCached())
            .thenReturn(single)
    }


    private fun stubSaveProfile(completable: Completable) {
        whenever(store.saveProfile(any()))
            .thenReturn(completable)
    }

    private fun stubGetProfile(observable: Observable<List<ProfileEntity>>) {
        whenever(store.getProfile())
            .thenReturn(observable)
    }

    private fun stubMapperProfile(model: Profile, entity: ProfileEntity) {
        whenever(mapperProfile.mapFromEntity(entity))
            .thenReturn(model)
    }

    private fun stubIsCacheExpiredSkill(single: Single<Boolean>) {
        whenever(cache.isSkillCachedExpired())
            .thenReturn(single)
    }

    private fun stubAreSkillCached(single: Single<Boolean>) {
        whenever(cache.isSkillCached())
            .thenReturn(single)
    }

    private fun stubSaveSkill(completable: Completable) {
        whenever(store.saveSkill(any()))
            .thenReturn(completable)
    }

    private fun stubGetSkills(observable: Observable<List<SkillEntity>>) {
        whenever(store.getSkills())
            .thenReturn(observable)
    }

    private fun stubMapperSkill(model: Skill, entity: SkillEntity) {
        whenever(mapperSkill.mapFromEntity(entity))
            .thenReturn(model)
    }

    private fun stubIsCacheExpiredTimeLine(single: Single<Boolean>) {
        whenever(cache.isTimeLineCachedExpired())
            .thenReturn(single)
    }

    private fun stubAreTimeLineCached(single: Single<Boolean>) {
        whenever(cache.isTimeLineCached())
            .thenReturn(single)
    }

    private fun stubSaveTimeLine(completable: Completable) {
        whenever(store.saveTimeLine(any()))
            .thenReturn(completable)
    }

    private fun stubGetTimeLine(observable: Observable<List<TimeLineEntity>>) {
        whenever(store.getTimeLine())
            .thenReturn(observable)
    }

    private fun stubMapperTimeLine(model: TimeLine, entity: TimeLineEntity) {
        whenever(mapperTimeLine.mapFromEntity(entity))
            .thenReturn(model)
    }
}