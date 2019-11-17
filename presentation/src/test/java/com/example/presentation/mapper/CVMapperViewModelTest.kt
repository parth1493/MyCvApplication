package com.example.presentation.mapper

import com.example.presentation.factory.CVFactory
import junit.framework.Assert.assertEquals
import org.junit.Test

class CVMapperViewModelTest {

    private val profileMapper = ProfileViewMapper()
    private val skillMapper = SkillViewMapper()
    private val timeLineMapper = TimelineViewMapper()

    @Test
    fun assertProfileEqualData() {

        val profile = CVFactory.makeProfile()
        val model = profileMapper.mapToView(profile)

        assertEquals(profile.id, model.id)
        assertEquals(profile.name, model.name)
        assertEquals(profile.role, model.role)
        assertEquals(profile.profilepic, model.profilepic)
    }

    @Test
    fun assertSkillEqualData() {

        val skill = CVFactory.makeSkill()
        val model = skillMapper.mapToView(skill)

        assertEquals(skill.id, model.id)
        assertEquals(skill.skillname, model.skillname)
        assertEquals(skill.skillValue, model.skillValue)
    }

    @Test
    fun assertTimeLineEqualData() {

        val timeline = CVFactory.makeTimeLine()
        val model = timeLineMapper.mapToView(timeline)

        assertEquals(timeline.id, model.id)
        assertEquals(timeline.name, model.name)
        assertEquals(timeline.roleName, model.roleName)
        assertEquals(timeline.dateToFrom, model.dateToFrom)
        assertEquals(timeline.image, model.image)
        assertEquals(timeline.responsibilities, model.responsibilities)
        assertEquals(timeline.timeLineState, model.timeLineState)
    }
}