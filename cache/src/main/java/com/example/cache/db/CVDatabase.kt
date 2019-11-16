package com.example.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cache.dao.*
import com.example.cache.model.*
import javax.inject.Inject

@Database(entities = arrayOf(CacheProfile::class,CacheSkill::class,CacheTimeline::class,
                             ProfileConfig::class,SkillConfig::class,TimelineConfig::class), version = 1)
abstract class CVDatabase @Inject constructor():RoomDatabase() {

    abstract fun cachedProfileDao(): CacheProfileDao
    abstract fun cachedSkillDao(): CacheSkillDao
    abstract fun cachedTimelineDao(): CacheTimeLineDao

    abstract fun profileConfigDao(): ProfileConfigDao
    abstract fun skillConfigDao() : SkillConfigDao
    abstract fun timelineConfigDao(): TimelineConfigDao

    companion object {
        private var INSTANCE: CVDatabase? = null
        private val lock = Any()
        fun getInstance(context: Context): CVDatabase {
            if (INSTANCE == null) {
                synchronized(lock) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            CVDatabase::class.java, "CV.db")
                            .build()
                    }
                    return INSTANCE as CVDatabase
                }
            }
            return INSTANCE as CVDatabase
        }
    }
}