package com.example.remote.mapper

import com.example.data.model.ProfileEntity
import com.example.data.model.TimeLineEntity
import com.example.remote.model.ProfileModel
import com.example.remote.model.TimeLineModel
import javax.inject.Inject

class TimelineResponseModelMapper @Inject constructor(): ModelMapper<TimeLineModel,TimeLineEntity>{

    override fun mapFromModel(model: TimeLineModel): TimeLineEntity {
        return TimeLineEntity(model.id,model.name,model.roleName,model.dateToFrom,model.image,model.responsibilities,model.timeLineState)
    }
}