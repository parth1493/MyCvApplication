package com.example.remote.mapper

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.remote.model.ProfileModel
import com.example.remote.model.SkillModel
import javax.inject.Inject

class SkillResponseModelMapper @Inject constructor(): ModelMapper<SkillModel,SkillEntity>{

    override fun mapFromModel(model: SkillModel): SkillEntity {
        return SkillEntity(model.id,model.skillname,model.skillValue)
    }
}