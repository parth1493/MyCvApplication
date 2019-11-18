package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.db.CVConfigConstants
import com.example.cache.model.ProfileConfig
import io.reactivex.Maybe

@Dao
abstract class ProfileConfigDao {

    @Query(CVConfigConstants.PROFILE_QUERY_CONFIG)
    abstract fun getConfig(): Maybe<ProfileConfig>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertConfig(config: ProfileConfig)
}