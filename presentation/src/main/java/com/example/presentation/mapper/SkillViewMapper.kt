package com.example.presentation.mapper

import com.example.domain.model.Skill
import com.example.presentation.model.SkillView
import javax.inject.Inject

open class SkillViewMapper @Inject constructor() : Mapper<SkillView,Skill>{

    override fun mapToView(skillEntity: Skill): SkillView {
        return SkillView(skillEntity.id,skillEntity.skillname,skillEntity.skillValue)
    }
}