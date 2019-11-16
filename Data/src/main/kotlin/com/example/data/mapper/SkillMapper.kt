package com.example.data.mapper

import com.example.data.model.SkillEntity
import com.example.domain.model.Skill
import javax.inject.Inject

class SkillMapper @Inject constructor(): EntityMapper <SkillEntity, Skill> {

    override fun mapFromEntity(skillEntity: SkillEntity): Skill {
        return Skill(skillEntity.id,skillEntity.skillname,skillEntity.skillValue)
    }

    override fun mapToEntity(skills: Skill): SkillEntity {
        return SkillEntity(skills.id,skills.skillname,skills.skillValue)
    }
}