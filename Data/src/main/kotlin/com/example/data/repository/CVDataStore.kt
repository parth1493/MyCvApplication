package com.example.data.repository

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface CVDataStore {

    fun saveProfile(profiles : List<ProfileEntity>) : Completable

    fun cleanProfile(): Completable

    fun getProfile(): Observable<List<ProfileEntity>>

    fun saveSkill(skills:List<SkillEntity>) : Completable

    fun cleanSkills(): Completable

    fun getSkills(): Observable<List<SkillEntity>>

    fun saveTimeLine(timeLine : List<TimeLineEntity>) : Completable

    fun cleanTimeLine(): Completable

    fun getTimeLine(): Observable<List<TimeLineEntity>>
}