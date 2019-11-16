package com.example.data.mapper

import com.example.data.model.ProfileEntity
import com.example.data.model.TimeLineEntity
import com.example.domain.model.Profile
import com.example.domain.model.Timeline
import javax.inject.Inject

class TimeLineMapper @Inject constructor(): EntityMapper<TimeLineEntity,Timeline>{

    override fun mapFromEntity(entity: TimeLineEntity): Timeline {
        return  Timeline(entity.id,entity.name,entity.roleName,entity.dateToFrom,entity.image,entity.responsibilities,entity.timeLineState)
    }

    override fun mapToEntity(entity: Timeline): TimeLineEntity {
        return  TimeLineEntity(entity.id,entity.name,entity.roleName,entity.dateToFrom,entity.image,entity.responsibilities,entity.timeLineState)

    }
}