package com.example.cache.mapper

import com.example.cache.factory.CVCachedDataFactory
import com.example.cache.model.CacheSkill
import com.example.data.model.SkillEntity
import org.junit.Test
import kotlin.test.assertEquals

class CachedSkillMapperTest {
    private val mapper = CachedSkillMapper()

    @Test
    fun mapFromCachedMapsData() {
        val model = CVCachedDataFactory.makeCachedSkill()
        val entity = mapper.mapFromCached(model)

        assertEqualData(model, entity)
    }

    @Test
    fun mapToCachedMapsData() {
        val entity = CVCachedDataFactory.makeCachedSkillEntity()
        val model = mapper.mapToCached(entity)

        assertEqualData(model, entity)
    }

    private fun assertEqualData(model: CacheSkill, entity: SkillEntity) {
        assertEquals(model.id, entity.id)
        assertEquals(model.skillname, entity.skillname)
        assertEquals(model.skillValue, entity.skillValue)
    }
}