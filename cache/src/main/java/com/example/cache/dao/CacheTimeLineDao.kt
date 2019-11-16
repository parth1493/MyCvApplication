package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.db.CVConstants
import com.example.cache.model.CacheTimeline
import io.reactivex.Flowable

@Dao
interface CacheTimeLineDao {

    @Query(CVConstants.QUERY_TIMELINE)
    abstract fun getTimeline(): Flowable<List<CacheTimeline>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertTimeline(timeline: List<CacheTimeline>)

    @Query(CVConstants.DELETE_QUERY_TIMELINE)
    abstract fun deleteTimeline()

}