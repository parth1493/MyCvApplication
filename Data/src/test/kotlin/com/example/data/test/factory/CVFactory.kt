package com.example.data.test

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.test.factory.DataFactory
import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.TimeLine

object CVFactory {

    fun makeProfileEntity():ProfileEntity{
        return ProfileEntity(
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

    fun makeSkillEntity(): SkillEntity {
        return SkillEntity(
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

    fun makeTimeLineEntity(): TimeLineEntity {
        return TimeLineEntity(
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
}