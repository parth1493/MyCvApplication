package com.example.cache.mapper

import com.example.cache.factory.CVCachedDataFactory
import com.example.cache.model.CacheTimeline
import com.example.data.model.TimeLineEntity
import org.junit.Test
import kotlin.test.assertEquals

class CachedTimelineMapperTest {
    private val mapper = CachedTimelineMapper()

    @Test
    fun mapFromCachedMapsData() {
        val model = CVCachedDataFactory.makeCachedTimeLine()
        val entity = mapper.mapFromCached(model)

        assertEqualData(model, entity)
    }

    @Test
    fun mapToCachedMapsData() {
        val entity = CVCachedDataFactory.makeCachedTimeLineEntity()
        val model = mapper.mapToCached(entity)

        assertEqualData(model, entity)
    }

    private fun assertEqualData(model: CacheTimeline, entity: TimeLineEntity) {
        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.dateToFrom, entity.dateToFrom)
        assertEquals(model.image, entity.image)
        assertEquals(model.responsibilities, entity.responsibilities)
        assertEquals(model.roleName, entity.roleName)
        assertEquals(model.timeLineState, entity.timeLineState)
    }
}