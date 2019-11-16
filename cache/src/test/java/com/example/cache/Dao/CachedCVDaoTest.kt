package com.example.cache.Dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.cache.db.CVDatabase
import com.example.cache.factory.CVCachedDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CachedCVDaoTest {

    @Rule
    @JvmField var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val database = Room.inMemoryDatabaseBuilder(
        RuntimeEnvironment.systemContext,
        CVDatabase::class.java)
        .allowMainThreadQueries()
        .build()

    @After
    fun closeDb() {
        database.close()
    }

    @Test
    fun getProfileReturnsData() {
        val profile = CVCachedDataFactory.makeCachedProfile()
        database.cachedProfileDao().insertProfile(listOf(profile))

        val testObserver = database.cachedProfileDao().getProfile().test()
        testObserver.assertValue(listOf(profile))
    }

    @Test
    fun deleteProfileClearsData() {
        val profile = CVCachedDataFactory.makeCachedProfile()
        database.cachedProfileDao().insertProfile(listOf(profile))
        database.cachedProfileDao().deleteProfile()

        val testObserver = database.cachedProfileDao().getProfile().test()
        testObserver.assertValue(emptyList())
    }

    @Test
    fun getSkillReturnsData() {
        val skill = CVCachedDataFactory.makeCachedSkill()
        database.cachedSkillDao().insertSkill(listOf(skill))

        val testObserver = database.cachedSkillDao().getSkill().test()
        testObserver.assertValue(listOf(skill))
    }

    @Test
    fun deleteSkillClearsData() {
        val skill = CVCachedDataFactory.makeCachedSkill()
        database.cachedSkillDao().insertSkill(listOf(skill))
        database.cachedSkillDao().deleteSkill()

        val testObserver = database.cachedSkillDao().getSkill().test()
        testObserver.assertValue(emptyList())
    }

    @Test
    fun getTimelineReturnsData() {
        val timeline = CVCachedDataFactory.makeCachedTimeLine()
        database.cachedTimelineDao().insertTimeline(listOf(timeline))

        val testObserver = database.cachedTimelineDao().getTimeline().test()
        testObserver.assertValue(listOf(timeline))
    }

    @Test
    fun deleteTimelineClearsData() {
        val timeline = CVCachedDataFactory.makeCachedTimeLine()
        database.cachedTimelineDao().insertTimeline(listOf(timeline))
        database.cachedTimelineDao().deleteTimeline()

        val testObserver = database.cachedTimelineDao().getTimeline().test()
        testObserver.assertValue(emptyList())
    }

}