package com.example.presentation.mapper

import com.example.domain.model.TimeLine
import com.example.presentation.model.TimelineView
import javax.inject.Inject

open class TimelineViewMapper @Inject constructor(): Mapper<TimelineView,TimeLine> {

    override fun mapToView(entity: TimeLine): TimelineView {
        return  TimelineView(entity.id,entity.name,entity.roleName,entity.dateToFrom,entity.image,
                             entity.responsibilities,entity.timeLineState)
    }
}