package com.example.domain.interactor.loadtimeline

import com.example.domain.executor.PostExecutionThread
import com.example.domain.ObservableUseCase
import com.example.domain.model.TimeLine
import com.example.domain.respository.CVRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetTimeLine @Inject constructor(
    private val cvRepository: CVRepository,
    postExecutionThread: PostExecutionThread):
    ObservableUseCase<List<TimeLine>, Nothing?>(postExecutionThread){
    public override fun buildUseCaseObservable(param: Nothing?): Observable<List<TimeLine>> {
        return  cvRepository.getTimeLine()
    }

}