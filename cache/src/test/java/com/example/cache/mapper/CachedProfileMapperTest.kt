package com.example.cache.mapper

import com.example.cache.factory.CVCachedDataFactory
import com.example.cache.model.CacheProfile
import com.example.data.model.ProfileEntity
import org.junit.Test
import kotlin.test.assertEquals

class CachedProfileMapperTest {

    private val mapper = CachedProfileMapper()

    @Test
    fun mapFromCachedMapsData() {
        val model = CVCachedDataFactory.makeCachedProfile()
        val entity = mapper.mapFromCached(model)

        assertEqualData(model, entity)
    }

    @Test
    fun mapToCachedMapsData() {
        val entity = CVCachedDataFactory.makeCachedProfileEntity()
        val model = mapper.mapToCached(entity)

        assertEqualData(model, entity)
    }

    private fun assertEqualData(model: CacheProfile, entity: ProfileEntity) {
        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.role, entity.role)
        assertEquals(model.profilepic, entity.profilepic)
    }
}