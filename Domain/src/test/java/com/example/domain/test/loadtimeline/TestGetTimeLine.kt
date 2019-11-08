package com.example.domain.test.loadtimeline

import com.example.domain.executor.PostExecutionThread
import com.example.domain.fakedata.ProfileFakeDataFactory
import com.example.domain.fakedata.TimeLineFakeDataFactory
import com.example.domain.interactor.loadtimeline.GetTimeLine
import com.example.domain.model.Profile
import com.example.domain.model.Timeline
import com.example.domain.respository.CVRepository
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

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
        stubGetProjects(Observable.just(TimeLineFakeDataFactory.makeTimeLineList(2)))
        val testObserver = getTimeline.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val timeline = TimeLineFakeDataFactory.makeTimeLineList(2)
        stubGetProjects(Observable.just(timeline))
        val testObserver = getTimeline.buildUseCaseObservable().test()
        testObserver.assertValue(timeline)
    }

    private fun stubGetProjects(observable: Observable<List<Timeline>>) {
        whenever(cvRepository.getTimeLine())
            .thenReturn(observable)
    }
}