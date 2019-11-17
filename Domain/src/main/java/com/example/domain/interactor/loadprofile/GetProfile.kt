package com.example.domain.interactor.loadprofile

import com.example.domain.executor.PostExecutionThread
import com.example.domain.ObservableUseCase
import com.example.domain.model.Profile
import com.example.domain.respository.CVRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetProfile @Inject constructor(

    private val cvRepository: CVRepository,

    postExecutionThread: PostExecutionThread):
    ObservableUseCase<List<Profile>, Nothing?>(postExecutionThread){
    public override fun buildUseCaseObservable(param: Nothing?): Observable<List<Profile>> {
        return  cvRepository.getProfile()
    }
}