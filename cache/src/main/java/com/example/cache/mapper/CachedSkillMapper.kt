package com.example.cache.mapper

import com.example.cache.model.CacheSkill
import com.example.data.model.SkillEntity
import javax.inject.Inject

class CachedSkillMapper @Inject constructor():CacherMapper<CacheSkill, SkillEntity> {
    override fun mapFromCached(model: CacheSkill): SkillEntity {
        return SkillEntity(model.id,model.skillname,model.skillValue)
    }

    override fun mapToCached(model: SkillEntity): CacheSkill {
        return CacheSkill(model.id,model.skillname,model.skillValue)
    }
}