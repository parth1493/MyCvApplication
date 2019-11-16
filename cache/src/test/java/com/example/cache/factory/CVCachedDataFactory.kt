package com.example.cache.factory

import com.example.cache.model.CacheProfile
import com.example.cache.model.CacheSkill
import com.example.cache.model.CacheTimeline
import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity

object CVCachedDataFactory {

    fun makeCachedProfileEntity():ProfileEntity{
        return ProfileEntity(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeCachedProfile(): CacheProfile {
        return CacheProfile(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeCachedSkillEntity(): SkillEntity {
        return SkillEntity(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeCachedSkill(): CacheSkill {
        return CacheSkill(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeCachedTimeLineEntity(): TimeLineEntity {
        return TimeLineEntity(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomInt()
        )
    }

    fun makeCachedTimeLine(): CacheTimeline {
        return CacheTimeline(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomInt()
        )
    }
}