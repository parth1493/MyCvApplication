package com.example.ui.mapper

import com.example.ui.factory.UIFactory
import org.junit.Test
import kotlin.test.assertEquals


class UITimelineMapperTest {

    private val mapper = UITimelineMapper()

    @Test
    fun mapFromModelMapsData(){
        val model = UIFactory.makeTimeLine()
        val entity = mapper.mapToView(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.dateToFrom, entity.dateToFrom)
        assertEquals(model.image, entity.image)
        assertEquals(model.responsibilities, entity.responsibilities)
        assertEquals(model.roleName, entity.roleName)
        assertEquals(model.timeLineState, entity.timeLineState)
    }
}