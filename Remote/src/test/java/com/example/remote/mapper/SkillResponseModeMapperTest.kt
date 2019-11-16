package com.example.remote.mapper

import com.example.remote.factory.CVDataFactory
import org.junit.Test
import kotlin.test.assertEquals

class SkillResponseModeMapperTest {

    private val mapper = SkillResponseModelMapper()

    @Test
    fun mapFromModelMapsData(){
        val model = CVDataFactory.makeSkill()
        val entity = mapper.mapFromModel(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.skillname, entity.skillname)
        assertEquals(model.skillValue, entity.skillValue)
    }
}