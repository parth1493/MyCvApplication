package com.example.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cache.db.CVConstants.DELETE_QUERY_SKILL
import com.example.cache.db.CVConstants.QUERY_SKILL
import com.example.cache.model.CacheSkill
import io.reactivex.Flowable

@Dao
abstract class CacheSkillDao {

    @Query(QUERY_SKILL)
    abstract fun getSkill(): Flowable<List<CacheSkill>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertSkill(skill: List<CacheSkill>)

    @Query(DELETE_QUERY_SKILL)
    abstract fun deleteSkill()
}