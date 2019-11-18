package com.example.ui.test.factory

import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.TimeLine

object TestUIFactory {

    fun makeProfile():Profile{
        return Profile(
            TestDataFactory.randomInt(),
            TestDataFactory.randomString(),
            TestDataFactory.randomString(),
            TestDataFactory.randomString()
        )
    }

    fun makeSkill(): Skill {
        return Skill(
            TestDataFactory.randomInt(),
            TestDataFactory.randomString(),
            TestDataFactory.randomFloat()
        )
    }

    fun makeTimeLine(): TimeLine {
        return TimeLine(
            TestDataFactory.randomInt(),
            TestDataFactory.randomString(),
            TestDataFactory.randomString(),
            TestDataFactory.randomString(),
            TestDataFactory.randomString(),
            TestDataFactory.randomString(),
            TestDataFactory.randomInt()
        )
    }
}