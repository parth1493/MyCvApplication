package com.example.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.interactor.loadprofile.GetProfile
import com.example.domain.interactor.loadtimeline.GetTimeLine
import com.example.domain.model.Profile
import com.example.domain.model.TimeLine
import com.example.presentation.factory.CVFactory
import com.example.presentation.factory.DataFactory
import com.example.presentation.mapper.ProfileViewMapper
import com.example.presentation.mapper.TimelineViewMapper
import com.example.presentation.model.ProfileView
import com.example.presentation.model.TimelineView
import com.example.presentation.state.ResourceState
import com.example.presentation.viewmodel.ProfileViewModel
import com.nhaarman.mockito_kotlin.*
import io.reactivex.observers.DisposableObserver
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Captor

@RunWith(JUnit4::class)
class TimelineViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()
    var getTimeline = mock<GetTimeLine>()
    var timeLineMapper = mock<TimelineViewMapper>()
    var timelineViewModel = TimelineViewModel(getTimeline,timeLineMapper)

    @Captor
    val captor = argumentCaptor<DisposableObserver<List<TimeLine>>>()

    @Test
    fun fetchTimelineReturnSuccess(){
        timelineViewModel.fetchSkill()
        verify(getTimeline,times(1)).execute(any(),eq(null))
    }

    @Test
    fun fetchTimelineReturnsSuccess() {
        val timeline = CVFactory.makeTimelimeList(2)
        val timelineView = CVFactory.makeTimeLineViewList(2)
        stubTimelineMapperMapToView(timelineView[0], timeline[0])
        stubTimelineMapperMapToView(timelineView[1], timeline[1])

        timelineViewModel.fetchSkill()

        verify(getTimeline).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(timeline)
        assertEquals(ResourceState.SUCCESS, timelineViewModel.getTimeline().value?.status)
    }

    @Test
    fun fetchTimelineReturnsData() {
        val timeline = CVFactory.makeTimelimeList(2)
        val timelineView = CVFactory.makeTimeLineViewList(2)
        stubTimelineMapperMapToView(timelineView[0], timeline[0])
        stubTimelineMapperMapToView(timelineView[1], timeline[1])

        timelineViewModel.fetchSkill()

        verify(getTimeline).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(timeline)
        assertEquals(timelineView, timelineViewModel.getTimeline().value?.data)
    }

    @Test
    fun fetchTimelineReturnsError() {
        timelineViewModel.fetchSkill()

        verify(getTimeline).execute(captor.capture(), eq(null))
        captor.firstValue.onError(java.lang.RuntimeException())
        assertEquals(ResourceState.ERROR, timelineViewModel.getTimeline().value?.status)
    }

    @Test
    fun fetchTimelineReturnsMessageForError() {
        val errorMessage = DataFactory.randomString()
        timelineViewModel.fetchSkill()

        verify(getTimeline).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(errorMessage))
        assertEquals(errorMessage, timelineViewModel.getTimeline().value?.message)
    }

    private fun stubTimelineMapperMapToView(timelineView: TimelineView, timeline: TimeLine) {
        whenever(timeLineMapper.mapToView(timeline))
            .thenReturn(timelineView)
    }
}