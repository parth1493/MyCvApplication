package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.loadprofile.GetProfile
import com.example.domain.model.Profile
import com.example.presentation.mapper.ProfileViewMapper
import com.example.presentation.model.ProfileView
import com.example.presentation.state.Resource
import com.example.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class ProfileViewModel @Inject constructor(
    private val getProfile: GetProfile?,
    private val mapper:ProfileViewMapper)
    : ViewModel(){

    private val liveData: MutableLiveData<Resource<List<ProfileView>>> = MutableLiveData()

//    init {
//        fetchProfile()
//    }

    override fun onCleared() {
        getProfile?.dispose()
        super.onCleared()
    }

    fun getProfile(): LiveData<Resource<List<ProfileView>>> {
        return liveData
    }

    fun fetchProfile() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getProfile?.execute(ProfileSubscriber())
    }

    inner class ProfileSubscriber: DisposableObserver<List<Profile>>() {
        override fun onNext(t: List<Profile>) {
            liveData.postValue(
                Resource(ResourceState.SUCCESS,
                    t.map { mapper.mapToView(it) }, null)
            )
        }
        override fun onComplete() { }
        override fun onError(e: Throwable) {
            liveData.postValue(Resource(ResourceState.ERROR, null, e.localizedMessage))
        }
    }
}