package com.example.ui.mapper

import com.example.ui.factory.UIFactory
import org.junit.Test
import kotlin.test.assertEquals

class UISkillMapperTest {

    private val mapper = UISkillMapper()

    @Test
    fun mapFromModelMapsData(){
        val model = UIFactory.makeSkill()
        val entity = mapper.mapToView(model)

        assertEquals(model.id, entity.id)
        assertEquals(model.skillname, entity.skillname)
        assertEquals(model.skillValue, entity.skillValue)
    }
}