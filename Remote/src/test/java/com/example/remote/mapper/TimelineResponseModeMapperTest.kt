package com.example.remote.mapper

import com.example.remote.factory.CVDataFactory
import org.junit.Test
import kotlin.test.assertEquals

class TimelineResponseModeMapperTest {

    private val mapper = TimelineResponseModelMapper()

    @Test
    fun mapFromModelMapsData(){
        val model = CVDataFactory.makeTimeLine()
        val entity = mapper.mapFromModel(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.dateToFrom, entity.dateToFrom)
        assertEquals(model.image, entity.image)
        assertEquals(model.responsibilities, entity.responsibilities)
        assertEquals(model.roleName, entity.roleName)
        assertEquals(model.timeLineState, entity.timeLineState)
    }
}