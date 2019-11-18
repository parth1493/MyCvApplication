package com.example.ui.mapper

import com.example.ui.factory.UIFactory
import org.junit.Test
import kotlin.test.assertEquals


class UIProfileMapperTest {

    private val mapper = UIProfileMapper()

    @Test
    fun mapFromModelMapsData(){
        val model = UIFactory.makeProfile()
        val entity = mapper.mapToView(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.role, entity.role)
        assertEquals(model.profilepic, entity.profilepic)
    }
}