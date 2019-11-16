package com.example.cache

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.cache.db.CVDatabase
import com.example.cache.factory.CVCachedDataFactory
import com.example.cache.mapper.CachedProfileMapper
import com.example.cache.mapper.CachedSkillMapper
import com.example.cache.mapper.CachedTimelineMapper
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CVCachedImplTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
        RuntimeEnvironment.systemContext,
        CVDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    private val profileMapper = CachedProfileMapper()
    private val skillMapper =  CachedSkillMapper()
    private val timelineMapper = CachedTimelineMapper()
    private val cache = CVCachedImpl(database, profileMapper,skillMapper,timelineMapper)

    @Test
    fun clearProfileTablesCompletes() {
        val testObserver = cache.clearProfile().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveProfileCompletes() {
        val profile = listOf(CVCachedDataFactory.makeCachedProfileEntity())

        val testObserver = cache.saveProfile(profile).test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val profile = listOf(CVCachedDataFactory.makeCachedProfileEntity())
        cache.saveProfile(profile).test()

        val testObserver = cache.getProfile().test()
        testObserver.assertValue(profile)
    }

    @Test
    fun isProfileCacheReturnsData() {
        val projects = listOf(CVCachedDataFactory.makeCachedProfileEntity())
        cache.saveProfile(projects).test()

        val testObserver = cache.isProfileCached().test()
        testObserver.assertValue(true)
    }

    @Test
    fun setProfileLastCacheTimeCompletes() {
        val testObserver = cache.setProfileLastCachedTime(1000L).test()
        testObserver.assertComplete()
    }

    @Test
    fun clearSkillTablesCompletes() {
        val testObserver = cache.cleanSkillS().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveSkillCompletes() {
        val skill = listOf(CVCachedDataFactory.makeCachedSkillEntity())

        val testObserver = cache.saveSkills(skill).test()
        testObserver.assertComplete()
    }

    @Test
    fun getSkillReturnsData() {
        val skill = listOf(CVCachedDataFactory.makeCachedSkillEntity())
        cache.saveSkills(skill).test()

        val testObserver = cache.getSkillS().test()
        testObserver.assertValue(skill)
    }

    @Test
    fun isSkillCacheReturnsData() {
        val skill = listOf(CVCachedDataFactory.makeCachedSkillEntity())
        cache.saveSkills(skill).test()

        val testObserver = cache.isSkillCached().test()
        testObserver.assertValue(true)
    }

    @Test
    fun setSkillLastCacheTimeCompletes() {
        val testObserver = cache.setSkillsLastCachedTime(1000L).test()
        testObserver.assertComplete()
    }

    //timeline
    @Test
    fun clearTimelineTablesCompletes() {
        val testObserver = cache.clearTimeLine().test()
        testObserver.assertComplete()
    }

    @Test
    fun saveTimelineCompletes() {
        val timeline = listOf(CVCachedDataFactory.makeCachedTimeLineEntity())

        val testObserver = cache.saveTimeLine(timeline).test()
        testObserver.assertComplete()
    }

    @Test
    fun getTimelineReturnsData() {
        val timeline = listOf(CVCachedDataFactory.makeCachedTimeLineEntity())
        cache.saveTimeLine(timeline).test()

        val testObserver = cache.getTimeLine().test()
        testObserver.assertValue(timeline)
    }

    @Test
    fun isTimelineCacheReturnsData() {
        val timeline = listOf(CVCachedDataFactory.makeCachedTimeLineEntity())
        cache.saveTimeLine(timeline).test()

        val testObserver = cache.isSkillCached().test()
        testObserver.assertValue(true)
    }

    @Test
    fun setTimelineLastCacheTimeCompletes() {
        val testObserver = cache.setTimeLineLastCachedTime(1000L).test()
        testObserver.assertComplete()
    }

}