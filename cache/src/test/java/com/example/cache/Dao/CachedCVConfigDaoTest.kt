package com.example.cache.Dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import com.example.cache.db.CVDatabase
import com.example.cache.factory.CVCachedDataFactory
import com.example.cache.factory.ProfileConfigDataFactory
import com.example.cache.factory.SkillConfigDataFactory
import com.example.cache.factory.TimelineConfigDataFactory
import org.junit.After
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class CachedCVConfigDaoTest {

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
    fun saveProfileConfigData() {
        val profile = ProfileConfigDataFactory.makeCachedConfig()
        database.profileConfigDao().insertConfig(profile)

        val testObserver = database.profileConfigDao().getConfig().test()
        testObserver.assertValue(profile)
    }

    @Test
    fun saveSkillConfigData() {
        val skill = SkillConfigDataFactory.makeCachedConfig()
        database.skillConfigDao().insertConfig(skill)

        val testObserver = database.skillConfigDao().getConfig().test()
        testObserver.assertValue(skill)
    }

    @Test
    fun saveTimelineConfigData() {
        val timeline = TimelineConfigDataFactory.makeCachedConfig()
        database.timelineConfigDao().insertConfig(timeline)

        val testObserver = database.timelineConfigDao().getConfig().test()
        testObserver.assertValue(timeline)
    }

}