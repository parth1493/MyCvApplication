package com.example.domain.fakedata

import com.example.domain.model.Profile
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

object ProfileFakeDataFactory {

    private val counter = AtomicInteger()

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun getid(): Int {
        return counter.getAndIncrement()
    }

    fun makeProject(): Profile {
        return Profile(
            getid(),
            randomUuid(),
            randomUuid(),
            randomUuid()
        )
    }

    fun makeProfileList(count: Int): List<Profile> {
        val profile = mutableListOf<Profile>()
        repeat(count) {
            profile.add(makeProject())
        }
        return profile
    }
}