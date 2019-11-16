package com.example.data.mapper

import com.example.data.model.TimeLineEntity
import com.example.domain.model.TimeLine
import javax.inject.Inject

class TimeLineMapper @Inject constructor(): EntityMapper<TimeLineEntity,TimeLine>{

    override fun mapFromEntity(entity: TimeLineEntity): TimeLine {
        return  TimeLine(entity.id,entity.name,entity.roleName,entity.dateToFrom,entity.image,entity.responsibilities,entity.timeLineState)
    }

    override fun mapToEntity(entity: TimeLine): TimeLineEntity {
        return  TimeLineEntity(entity.id,entity.name,entity.roleName,entity.dateToFrom,entity.image,entity.responsibilities,entity.timeLineState)

    }
}