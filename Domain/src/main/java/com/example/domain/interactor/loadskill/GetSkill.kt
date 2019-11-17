package com.example.domain.interactor.loadskill

import com.example.domain.executor.PostExecutionThread
import com.example.domain.ObservableUseCase
import com.example.domain.model.Skill
import com.example.domain.respository.CVRepository
import io.reactivex.Observable
import javax.inject.Inject

open class GetSkill @Inject constructor(

    private val cvRepository: CVRepository,
    postExecutionThread: PostExecutionThread):
    ObservableUseCase<List<Skill>, Nothing?>(postExecutionThread){
    public override fun buildUseCaseObservable(param: Nothing?): Observable<List<Skill>> {
        return  cvRepository.getSkill()
    }

}