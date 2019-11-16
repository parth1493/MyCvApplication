package com.example.data.repository

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import io.reactivex.Observable

interface CVRemote {

    fun getProfile(): Observable<List<ProfileEntity>>
    fun getSkills(): Observable<List<SkillEntity>>
}