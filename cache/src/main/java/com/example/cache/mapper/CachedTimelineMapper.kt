package com.example.cache.mapper

import com.example.cache.model.CacheTimeline
import com.example.data.model.TimeLineEntity
import javax.inject.Inject

class CachedTimelineMapper @Inject constructor():CacherMapper<CacheTimeline, TimeLineEntity> {
    override fun mapFromCached(model: CacheTimeline): TimeLineEntity {
        return TimeLineEntity(model.id,model.name,model.roleName,model.dateToFrom,model.image,model.responsibilities,model.timeLineState)
    }

    override fun mapToCached(model: TimeLineEntity): CacheTimeline {
        return CacheTimeline(model.id,model.name,model.roleName,model.dateToFrom,model.image,model.responsibilities,model.timeLineState)
    }
}