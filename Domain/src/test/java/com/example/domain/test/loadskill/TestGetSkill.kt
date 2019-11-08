package com.example.domain.test.loadskill

import com.example.domain.executor.PostExecutionThread
import com.example.domain.fakedata.ProfileFakeDataFactory
import com.example.domain.fakedata.SkillFakeDataFactory
import com.example.domain.fakedata.TimeLineFakeDataFactory
import com.example.domain.interactor.loadskill.GetSkill
import com.example.domain.interactor.loadtimeline.GetTimeLine
import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.Timeline
import com.example.domain.respository.CVRepository
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class TestGetSkill {
    private lateinit var getSkill: GetSkill
    @Mock lateinit var cvRepository: CVRepository
    @Mock lateinit var postExecutionThread: PostExecutionThread

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        getSkill = GetSkill(cvRepository, postExecutionThread)
    }

    @Test
    fun getProfilesCompletes() {
        stubGetProjects(Observable.just(SkillFakeDataFactory.makeSkillList(2)))
        val testObserver = getSkill.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val skill = SkillFakeDataFactory.makeSkillList(2)
        stubGetProjects(Observable.just(skill))
        val testObserver = getSkill.buildUseCaseObservable().test()
        testObserver.assertValue(skill)
    }

    private fun stubGetProjects(observable: Observable<List<Skill>>) {
        whenever(cvRepository.getSkill())
            .thenReturn(observable)
    }
}