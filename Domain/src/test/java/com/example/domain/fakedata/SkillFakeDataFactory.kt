package com.example.domain.fakedata

import com.example.domain.model.Profile
import com.example.domain.model.Skill
import java.util.*
import java.util.concurrent.atomic.AtomicInteger
import java.awt.Color



object SkillFakeDataFactory {

    private val counter = AtomicInteger()

    private val ratingRandom = floatArrayOf(0.5f,5.0f,2.0f,5.0f,4.0f,3.5f)

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun getid(): Int {
        return counter.getAndIncrement()
    }

    fun getRating(): Float {
        val random = Random()
        return ratingRandom[random.nextInt(ratingRandom.size)]
    }

    fun makeSkill(): Skill {
        return Skill(
            getid(),
            randomUuid(),
            getRating()
        )
    }

    fun makeSkillList(count: Int): List<Skill> {
        val skill = mutableListOf<Skill>()
        repeat(count) {
            skill.add(makeSkill())
        }
        return skill
    }
}

