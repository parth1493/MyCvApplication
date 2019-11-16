package com.example.remote

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.remote.factory.CVDataFactory
import com.example.remote.mapper.ProfileResponseModelMapper
import com.example.remote.mapper.SkillResponseModelMapper
import com.example.remote.mapper.TimelineResponseModelMapper
import com.example.remote.model.*
import com.example.remote.service.CVService
import com.nhaarman.mockito_kotlin.any
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import io.reactivex.Observable
import org.junit.Test

class CVRemoteImplTest {

    private val profileMapper = mock<ProfileResponseModelMapper>()
    private val skillMapper = mock<SkillResponseModelMapper>()
    private val timelineMapper = mock<TimelineResponseModelMapper>()
    private val service = mock<CVService>()
    private val remote = CVRemoteImpl(service, profileMapper,skillMapper,timelineMapper)

    @Test
    fun getProfileCompletes() {
        stubProfileGetList(
            Observable.just(
                CVDataFactory.makeProfileResponse()))
        stubProjectsResponseModelMapperMapFromModel(any(),
            CVDataFactory.makeProfileEntity())

        val testObserver = remote.getProfile().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileCallsServer() {
        stubProfileGetList(
            Observable.just(
                CVDataFactory.makeProfileResponse()))
        stubProjectsResponseModelMapperMapFromModel(any(),
            CVDataFactory.makeProfileEntity())

        remote.getProfile().test()
        verify(service).getProfile()
    }

    private fun stubProfileGetList(observable: Observable<ProfileResposeModel>) {
        whenever(service.getProfile())
            .thenReturn(observable)
    }

    private fun stubProjectsResponseModelMapperMapFromModel(model: ProfileModel, entity: ProfileEntity) {
        whenever(profileMapper.mapFromModel(model))
            .thenReturn(entity)
    }

    @Test
    fun getSkillCompletes() {
        stubSkillGetList(
            Observable.just(
                CVDataFactory.makeSkillResponse()))
        stubSkillResponseModelMapperMapFromModel(any(),
            CVDataFactory.makeSkillEntity())

        val testObserver = remote.getSkills().test()
        testObserver.assertComplete()
    }

    @Test
    fun getSkillCallsServer() {
        stubSkillGetList(
            Observable.just(
                CVDataFactory.makeSkillResponse()))
        stubSkillResponseModelMapperMapFromModel(any(),
            CVDataFactory.makeSkillEntity())

        remote.getSkills().test()
        verify(service).getSkills()
    }

    private fun stubSkillGetList(observable: Observable<SkillResposeModel>) {
        whenever(service.getSkills())
            .thenReturn(observable)
    }

    private fun stubSkillResponseModelMapperMapFromModel(model: SkillModel, entity: SkillEntity) {
        whenever(skillMapper.mapFromModel(model))
            .thenReturn(entity)
    }

    @Test
    fun getTimelineCompletes() {
        stubTimelineGetList(
            Observable.just(
                CVDataFactory.makeTimelineResponse()))
        stubTimelineResponseModelMapperMapFromModel(any(),
            CVDataFactory.makeTimeLineEntity())

        val testObserver = remote.getTimeLine().test()
        testObserver.assertComplete()
    }

    @Test
    fun getTimelineCallsServer() {
        stubTimelineGetList(
            Observable.just(
                CVDataFactory.makeTimelineResponse()))
        stubTimelineResponseModelMapperMapFromModel(any(),
            CVDataFactory.makeTimeLineEntity())

        remote.getTimeLine().test()
        verify(service).getTimeLine()
    }

    private fun stubTimelineGetList(observable: Observable<TimelineResposeModel>) {
        whenever(service.getTimeLine())
            .thenReturn(observable)
    }


    private fun stubTimelineResponseModelMapperMapFromModel(model: TimeLineModel, entity: TimeLineEntity) {
        whenever(timelineMapper.mapFromModel(model))
            .thenReturn(entity)
    }
}