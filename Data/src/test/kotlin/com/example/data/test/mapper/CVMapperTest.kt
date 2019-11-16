package com.example.data.test.mapper

import com.example.data.mapper.ProfileMapper
import com.example.data.mapper.SkillMapper
import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.test.CVFactory
import com.example.domain.model.Profile
import com.example.domain.model.Skill
import org.junit.Assert.assertEquals
import org.junit.Test

class CVMapperTest {

    private val profileMapper = ProfileMapper()
    private val skillMapper = SkillMapper()
    @Test
    fun mapProfileFromEntityMapsData() {
        val entity = CVFactory.makeProfileEntity()
        val model = profileMapper.mapFromEntity(entity)
        assertProfileEqualData(entity, model)
    }

    @Test
    fun mapProfileToEntityMapsData() {
        val model = CVFactory.makeProfile()
        val entity = profileMapper.mapToEntity(model)
        assertProfileEqualData(entity, model)
    }

    @Test
    fun mapSkillsFromEntityMapsData() {
        val entity = CVFactory.makeSkillEntity()
        val model = skillMapper.mapFromEntity(entity)
        assertSkillEqualData(entity, model)
    }

    @Test
    fun mapSkillsToEntityMapsData() {
        val model = CVFactory.makeSkill()
        val entity = skillMapper.mapToEntity(model)
        assertSkillEqualData(entity, model)
    }

    private fun assertProfileEqualData(entity: ProfileEntity, model: Profile) {
        assertEquals(entity.id, model.id)
        assertEquals(entity.name, model.name)
        assertEquals(entity.role, model.role)
        assertEquals(entity.profilepic, model.profilepic)
    }

    private fun assertSkillEqualData(entity: SkillEntity, model: Skill) {
        assertEquals(entity.id, model.id)
        assertEquals(entity.skillname, model.skillname)
        assertEquals(entity.skillValue, model.skillValue)
    }
}