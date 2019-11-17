package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.loadskill.GetSkill
import com.example.domain.model.Skill
import com.example.presentation.mapper.SkillViewMapper
import com.example.presentation.model.SkillView
import com.example.presentation.state.Resource
import com.example.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class SkillViewModel @Inject constructor(
    private val getSkill: GetSkill?,
    private val mapper:SkillViewMapper)
    : ViewModel(){
        private val liveData: MutableLiveData<Resource<List<SkillView>>> = MutableLiveData()

//        init {
//            fetchSkill()
//        }

        override fun onCleared() {
            getSkill?.dispose()
            super.onCleared()
        }

        fun getSkills(): LiveData<Resource<List<SkillView>>> {
            return liveData
        }

        fun fetchSkill() {
            liveData.postValue(Resource(ResourceState.LOADING, null, null))
            getSkill?.execute(SkillSubscriber())
        }

        inner class SkillSubscriber: DisposableObserver<List<Skill>>() {
            override fun onNext(t: List<Skill>) {
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