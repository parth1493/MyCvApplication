package com.example.ui.test.factory

import java.util.*
import java.util.concurrent.ThreadLocalRandom

object TestDataFactory {
    fun randomString():String {
        return UUID.randomUUID().toString()
    }

    fun randomInt(): Int {
        return ThreadLocalRandom.current().nextInt(0, 1000 + 1)
    }

    fun randomFloat(): Float {
        return ThreadLocalRandom.current().nextFloat()
    }
}