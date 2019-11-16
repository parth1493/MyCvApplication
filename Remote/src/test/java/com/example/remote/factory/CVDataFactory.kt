package com.example.remote.factory

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.test.factory.DataFactory
import com.example.remote.model.*

object CVDataFactory {

    fun makeProfileEntity():ProfileEntity{
        return ProfileEntity(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeProfile(): ProfileModel {
        return ProfileModel(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString()
        )
    }

    fun makeProfileResponse(): ProfileResposeModel {
        return ProfileResposeModel(listOf(makeProfile(), makeProfile()))
    }

    fun makeSkillEntity(): SkillEntity {
        return SkillEntity(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeSkill(): SkillModel {
        return SkillModel(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomFloat()
        )
    }

    fun makeSkillResponse(): SkillResposeModel {
        return SkillResposeModel(listOf(makeSkill(), makeSkill()))
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

    fun makeTimeLine(): TimeLineModel {
        return TimeLineModel(
            DataFactory.randomInt(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomString(),
            DataFactory.randomInt()
        )
    }
    fun makeTimelineResponse(): TimelineResposeModel {
        return TimelineResposeModel(listOf(makeTimeLine(), makeTimeLine()))
    }
}