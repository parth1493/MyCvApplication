package com.example.data.store

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.repository.CVCache
import com.example.data.repository.CVDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class CVCacheDataStore @Inject constructor(
        private val cvCache : CVCache)
    : CVDataStore {
    override fun saveTimeLine(timeLine: List<TimeLineEntity>): Completable {
        return cvCache.saveTimeLine(timeLine)
            .andThen(cvCache.setTimeLineLastCachedTime(System.currentTimeMillis()))
    }

    override fun cleanTimeLine(): Completable {
        return cvCache.clearTimeLine()
    }

    override fun getTimeLine(): Observable<List<TimeLineEntity>> {
        return cvCache.getTimeLine()
    }

    override fun saveSkill(skills: List<SkillEntity>): Completable {
        return cvCache.saveSkills(skills)
            .andThen(cvCache.setSkillsLastCachedTime(System.currentTimeMillis()))
    }

    override fun cleanSkills(): Completable {
        return cvCache.cleanSkillS()
    }

    override fun getSkills(): Observable<List<SkillEntity>> {
        return cvCache.getSkillS()
    }

    override fun saveProfile(profiles : List<ProfileEntity>): Completable {
        return cvCache.saveProfile(profiles)
            .andThen(cvCache.setProfileLastCachedTime(System.currentTimeMillis()))
    }

    override fun cleanProfile(): Completable {
        return cvCache.clearProfile()
    }

    override fun getProfile(): Observable<List<ProfileEntity>> {
        return cvCache.getProfile()
    }
}