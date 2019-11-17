package com.example.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.interactor.loadprofile.GetProfile
import com.example.domain.interactor.loadskill.GetSkill
import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.presentation.factory.CVFactory
import com.example.presentation.factory.DataFactory
import com.example.presentation.mapper.ProfileViewMapper
import com.example.presentation.mapper.SkillViewMapper
import com.example.presentation.model.ProfileView
import com.example.presentation.model.SkillView
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
class SkillViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()
    var getSkill = mock<GetSkill>()
    var skillMapper = mock<SkillViewMapper>()
    var skillViewModel = SkillViewModel(getSkill,skillMapper)

    @Captor
    val captor = argumentCaptor<DisposableObserver<List<Skill>>>()

    @Test
    fun fetchSkillReturnSuccess(){
        skillViewModel.fetchSkill()
        verify(getSkill,times(1)).execute(any(),eq(null))
    }

    @Test
    fun fetchSkillReturnsSuccess() {
        val skill = CVFactory.makeSkillList(2)
        val skillView = CVFactory.makeSkillViewList(2)
        stubSkillMapperMapToView(skillView[0], skill[0])
        stubSkillMapperMapToView(skillView[1], skill[1])

        skillViewModel.fetchSkill()

        verify(getSkill).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(skill)
        assertEquals(ResourceState.SUCCESS, skillViewModel.getSkills().value?.status)
    }

    @Test
    fun fetchSkillReturnsData() {
        val skill = CVFactory.makeSkillList(2)
        val skillView = CVFactory.makeSkillViewList(2)
        stubSkillMapperMapToView(skillView[0], skill[0])
        stubSkillMapperMapToView(skillView[1], skill[1])

        skillViewModel.fetchSkill()

        verify(getSkill).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(skill)
        assertEquals(skillView, skillViewModel.getSkills().value?.data)
    }

    @Test
    fun fetchSkillReturnsError() {
        skillViewModel.fetchSkill()

        verify(getSkill).execute(captor.capture(), eq(null))
        captor.firstValue.onError(java.lang.RuntimeException())
        assertEquals(ResourceState.ERROR, skillViewModel.getSkills().value?.status)
    }

    @Test
    fun fetchSkillReturnsMessageForError() {
        val errorMessage = DataFactory.randomString()
        skillViewModel.fetchSkill()

        verify(getSkill).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(errorMessage))
        assertEquals(errorMessage, skillViewModel.getSkills().value?.message)
    }

    private fun stubSkillMapperMapToView(skillView: SkillView, skill: Skill) {
        whenever(skillMapper.mapToView(skill))
            .thenReturn(skillView)
    }
}