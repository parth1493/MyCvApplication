package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.db.CVConfigConstants
import com.example.cache.model.ProfileConfig
import com.example.cache.model.SkillConfig
import com.example.cache.model.TimelineConfig
import io.reactivex.Flowable

@Dao
abstract class TimelineConfigDao {

    @Query(CVConfigConstants.TIMELINE_QUERY_CONFIG)
    abstract fun getConfig(): Flowable<TimelineConfig>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertConfig(config: TimelineConfig)
}