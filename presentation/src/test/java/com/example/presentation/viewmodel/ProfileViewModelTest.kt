package com.example.presentation.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.domain.interactor.loadprofile.GetProfile
import com.example.domain.model.Profile
import com.example.presentation.factory.CVFactory
import com.example.presentation.factory.DataFactory
import com.example.presentation.mapper.ProfileViewMapper
import com.example.presentation.model.ProfileView
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
class ProfileViewModelTest {

    @get:Rule var instantTaskExecutorRule = InstantTaskExecutorRule()
    var getProfile = mock<GetProfile>()
    var profileMapper = mock<ProfileViewMapper>()
    var profileViewModel = ProfileViewModel(getProfile,profileMapper)

    @Captor
    val captor = argumentCaptor<DisposableObserver<List<Profile>>>()

    @Test
    fun fetchProfileReturnSuccess(){
        profileViewModel.fetchProfile()
        verify(getProfile,times(1)).execute(any(),eq(null))
    }

    @Test
    fun fetchProfileReturnsSuccess() {
        val profile = CVFactory.makeProfileList(2)
        val profileView = CVFactory.makeProfileViewList(2)
        stubProfileMapperMapToView(profileView[0], profile[0])
        stubProfileMapperMapToView(profileView[1], profile[1])

        profileViewModel.fetchProfile()

        verify(getProfile).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(profile)
        assertEquals(ResourceState.SUCCESS, profileViewModel.getProfile().value?.status)
    }

    @Test
    fun fetchProfileReturnsData() {
        val profile = CVFactory.makeProfileList(2)
        val profileView = CVFactory.makeProfileViewList(2)
        stubProfileMapperMapToView(profileView[0], profile[0])
        stubProfileMapperMapToView(profileView[1], profile[1])

        profileViewModel.fetchProfile()

        verify(getProfile).execute(captor.capture(), eq(null))
        captor.firstValue.onNext(profile)
        assertEquals(profileView, profileViewModel.getProfile().value?.data)
    }

    @Test
    fun fetchProfileReturnsError() {
        profileViewModel.fetchProfile()

        verify(getProfile).execute(captor.capture(), eq(null))
        captor.firstValue.onError(java.lang.RuntimeException())
        assertEquals(ResourceState.ERROR, profileViewModel.getProfile().value?.status)
    }

    @Test
    fun fetchProfileReturnsMessageForError() {
        val errorMessage = DataFactory.randomString()
        profileViewModel.fetchProfile()

        verify(getProfile).execute(captor.capture(), eq(null))
        captor.firstValue.onError(RuntimeException(errorMessage))
        assertEquals(errorMessage, profileViewModel.getProfile().value?.message)
    }

    private fun stubProfileMapperMapToView(profileView: ProfileView, profile: Profile) {
        whenever(profileMapper.mapToView(profile))
            .thenReturn(profileView)
    }
}