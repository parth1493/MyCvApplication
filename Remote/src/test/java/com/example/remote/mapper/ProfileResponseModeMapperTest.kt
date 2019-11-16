package com.example.remote.mapper

import com.example.remote.factory.CVDataFactory
import org.junit.Test
import kotlin.test.assertEquals

class ProfileResponseModeMapperTest {

    private val mapper = ProfileResponseModelMapper()

    @Test
    fun mapFromModelMapsData(){
        val model = CVDataFactory.makeProfile()
        val entity = mapper.mapFromModel(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.name, entity.name)
        assertEquals(model.role, entity.role)
        assertEquals(model.profilepic, entity.profilepic)
    }
}