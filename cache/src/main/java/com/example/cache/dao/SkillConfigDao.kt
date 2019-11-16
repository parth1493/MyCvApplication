package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.db.CVConfigConstants
import com.example.cache.model.ProfileConfig
import com.example.cache.model.SkillConfig
import io.reactivex.Flowable

@Dao
abstract class SkillConfigDao {
    @Query(CVConfigConstants.SKILL_CONFIG_TABLE_NAME)
    abstract fun getConfig(): Flowable<SkillConfig>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertConfig(config: SkillConfig)
}