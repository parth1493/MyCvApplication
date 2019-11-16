package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.db.CVConstants.DELETE_QUERY_PROFILE
import com.example.cache.db.CVConstants.QUERY_PROFILE
import com.example.cache.model.CacheProfile
import io.reactivex.Flowable

@Dao
abstract class CacheProfileDao {

    @Query(QUERY_PROFILE)
    abstract fun getProfile(): Flowable<List<CacheProfile>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertProfile(profile: List<CacheProfile>)

    @Query(DELETE_QUERY_PROFILE)
    abstract fun deleteProfile()
}