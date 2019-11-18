package com.example.ui.factory


import com.example.presentation.model.ProfileView
import com.example.presentation.model.SkillView
import com.example.presentation.model.TimelineView

object UIFactory {

    fun makeProfile():ProfileView{
        return ProfileView(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeSkill(): SkillView {
        return SkillView(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeTimeLine(): TimelineView {
        return TimelineView(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomInt()
        )
    }
}