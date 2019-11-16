package com.example.domain.test.loadskill

import com.example.domain.executor.PostExecutionThread
import com.example.domain.fakedata.SkillFakeDataFactory
import com.example.domain.interactor.loadskill.GetSkill
import com.example.domain.model.Skill
import com.example.domain.respository.CVRepository
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import java.lang.NullPointerException

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
        stubGetSkill(Observable.just(SkillFakeDataFactory.makeSkillList(2)))
        val testObserver = getSkill.buildUseCaseObservable().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val skill = SkillFakeDataFactory.makeSkillList(2)
        stubGetSkill(Observable.just(skill))
        val testObserver = getSkill.buildUseCaseObservable().test()
        testObserver.assertValue(skill)
    }

    private fun stubGetSkill(observable: Observable<List<Skill>>) {
        whenever(cvRepository.getSkill())
            .thenReturn(observable)
    }
    @Test(expected = NullPointerException::class)
    fun getSkillReturnsNullError() {
        getSkill.buildUseCaseObservable().test()
    }
}