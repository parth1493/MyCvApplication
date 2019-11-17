package com.example.ui.mapper

import com.example.domain.model.TimeLine
import com.example.presentation.model.TimelineView
import com.example.ui.model.UITimeline
import javax.inject.Inject

class UITimelineMapper @Inject constructor(): UIMapper<TimelineView, UITimeline> {

    override fun mapToView(presentation: TimelineView): UITimeline {
        return  UITimeline(presentation.id,presentation.name,presentation.roleName,presentation.dateToFrom,presentation.image,
            presentation.responsibilities,presentation.timeLineState)
    }
}