package com.example.domain.fakedata

import com.example.domain.model.Timeline
import java.util.*
import java.util.concurrent.atomic.AtomicInteger

object TimeLineFakeDataFactory {

    private val counter = AtomicInteger()

    fun randomUuid(): String {
        return UUID.randomUUID().toString()
    }

    fun getid(): Int {
        return counter.getAndIncrement()
    }

    fun makeTimeLine(): Timeline {
        return Timeline(
            getid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            getid()
        )
    }

    fun makeTimeLineList(count: Int): List<Timeline> {
        val timeLine = mutableListOf<Timeline>()
        repeat(count) {
            timeLine.add(makeTimeLine())
        }
        return timeLine
    }
}