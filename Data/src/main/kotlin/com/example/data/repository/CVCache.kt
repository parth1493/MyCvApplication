package com.example.data.repository

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface CVCache {

    fun clearProfile():Completable

    fun saveProfile(profiles : List<ProfileEntity>):Completable

    fun getProfile(): Observable<List<ProfileEntity>>

    fun isProfileCached(): Single<Boolean>

    fun setProfileLastCachedTime(lastCache: Long) : Completable

    fun isProfileCachedExpired(): Single<Boolean>

    fun cleanSkillS(): Completable

    fun saveSkills(skills : List<SkillEntity>): Completable

    fun getSkillS() : Observable<List<SkillEntity>>

    fun isSkillCached() : Single<Boolean>

    fun setSkillsLastCachedTime(lastCache: Long): Completable

    fun isSkillCachedExpired(): Single<Boolean>
}