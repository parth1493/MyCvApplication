package com.example.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.domain.interactor.loadtimeline.GetTimeLine
import com.example.domain.model.TimeLine
import com.example.presentation.mapper.TimelineViewMapper
import com.example.presentation.model.TimelineView
import com.example.presentation.state.Resource
import com.example.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class TimelineViewModel @Inject constructor(
    private val getTimeline: GetTimeLine,
    private val mapper:TimelineViewMapper)
    : ViewModel(){
    private val liveData: MutableLiveData<Resource<List<TimelineView>>> = MutableLiveData()

//    init {
//        fetchSkill()
//    }

    override fun onCleared() {
        getTimeline?.dispose()
        super.onCleared()
    }

    fun getTimeline(): LiveData<Resource<List<TimelineView>>> {
        return liveData
    }

    fun fetchSkill() {
        liveData.postValue(Resource(ResourceState.LOADING, null, null))
        getTimeline?.execute(TimelineSubscriber())
    }

    inner class TimelineSubscriber: DisposableObserver<List<TimeLine>>() {
        override fun onNext(t: List<TimeLine>) {
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