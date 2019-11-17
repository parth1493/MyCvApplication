package com.example.presentation.factory

import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.TimeLine
import com.example.presentation.model.ProfileView
import com.example.presentation.model.SkillView
import com.example.presentation.model.TimelineView

object CVFactory {

    fun makeProfileView():ProfileView{
        return ProfileView(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeProfile(): Profile {
        return Profile(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeSkillView(): SkillView {
        return SkillView(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeSkill(): Skill {
        return Skill(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeTimeLineView(): TimelineView {
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

    fun makeTimeLine(): TimeLine {
        return TimeLine(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomInt()
        )
    }

    fun makeProfileViewList(count: Int): List<ProfileView> {
        val profile = mutableListOf<ProfileView>()
        repeat(count) {
            profile.add(makeProfileView())
        }
        return profile
    }

    fun makeProfileList(count: Int): List<Profile> {
        val profile = mutableListOf<Profile>()
        repeat(count) {
            profile.add(makeProfile())
        }
        return profile
    }

    fun makeSkillViewList(count: Int): List<SkillView> {
        val skill = mutableListOf<SkillView>()
        repeat(count) {
            skill.add(makeSkillView())
        }
        return skill
    }

    fun makeSkillList(count: Int): List<Skill> {
        val skill = mutableListOf<Skill>()
        repeat(count) {
            skill.add(makeSkill())
        }
        return skill
    }

    fun makeTimeLineViewList(count: Int): List<TimelineView> {
        val timeLine = mutableListOf<TimelineView>()
        repeat(count) {
            timeLine.add(makeTimeLineView())
        }
        return timeLine
    }

    fun makeTimelimeList(count: Int): List<TimeLine> {
        val timeLine = mutableListOf<TimeLine>()
        repeat(count) {
            timeLine.add(makeTimeLine())
        }
        return timeLine
    }
}