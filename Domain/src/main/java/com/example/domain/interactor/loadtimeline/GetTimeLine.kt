package com.example.domain.interactor.loadtimeline

import com.example.domain.executor.PostExecutionThread
import com.example.domain.ObservableUseCase
import com.example.domain.model.Timeline
import com.example.domain.respository.CVRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTimeLine @Inject constructor(
    private val cvRepository: CVRepository,
    postExecutionThread: PostExecutionThread):
    ObservableUseCase<List<Timeline>, Nothing?>(postExecutionThread){
    public override fun buildUseCaseObservable(param: Nothing?): Observable<List<Timeline>> {
        return  cvRepository.getTimeLine()
    }

}