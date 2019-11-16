package com.example.domain.fakedata

import com.example.domain.model.TimeLine
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

    fun makeTimeLine(): TimeLine {
        return TimeLine(
            getid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            randomUuid(),
            getid()
        )
    }

    fun makeTimeLineList(count: Int): List<TimeLine> {
        val timeLine = mutableListOf<TimeLine>()
        repeat(count) {
            timeLine.add(makeTimeLine())
        }
        return timeLine
    }
}