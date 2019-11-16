package com.example.domain.test.loadtimeline

import com.example.domain.executor.PostExecutionThread
import com.example.domain.fakedata.TimeLineFakeDataFactory
import com.example.domain.interactor.loadtimeline.GetTimeLine
import com.example.domain.model.TimeLine
import com.example.domain.respository.CVRepository
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.NullPointerException

class TestGetTimeLine {
    private lateinit var getTimeline: GetTimeLine
    @Mock lateinit var cvRepository: CVRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getTimeline = GetTimeLine(cvRepository, postExecutionThread)
    }

    @Test
    fun getProfilesCompletes() {
        stubGetTimeLine(Observable.just(TimeLineFakeDataFactory.makeTimeLineList(2)))
        val testObserver = getTimeline.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val timeline = TimeLineFakeDataFactory.makeTimeLineList(2)
        stubGetTimeLine(Observable.just(timeline))
        val testObserver = getTimeline.buildUseCaseObservable().test()
        testObserver.assertValue(timeline)
    }

    private fun stubGetTimeLine(observable: Observable<List<TimeLine>>) {
        whenever(cvRepository.getTimeLine())
            .thenReturn(observable)
    }

    @Test(expected = NullPointerException::class)
    fun getTimeLineReturnsNullError() {
        getTimeline.buildUseCaseObservable().test()
    }
}