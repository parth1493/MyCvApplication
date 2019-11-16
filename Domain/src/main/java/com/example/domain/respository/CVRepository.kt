package com.example.domain.respository

import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.TimeLine
import io.reactivex.Observable

interface CVRepository {

    fun getProfile(): Observable<List<Profile>>
    fun getTimeLine(): Observable<List<TimeLine>>
    fun getSkill(): Observable<List<Skill>>
}