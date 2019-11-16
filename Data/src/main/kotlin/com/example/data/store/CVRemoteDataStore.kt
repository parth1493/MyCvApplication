package com.example.data.store

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.repository.CVDataStore
import com.example.data.repository.CVRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class CVRemoteDataStore @Inject constructor(
        private val cvRemote: CVRemote)
            :CVDataStore{
    override fun saveTimeLine(timeLine: List<TimeLineEntity>): Completable {
        throw  UnsupportedOperationException("Saving timeline is not supported")
    }

    override fun cleanTimeLine(): Completable {
        throw  UnsupportedOperationException("Cleaning timeline is not supported")
    }

    override fun getTimeLine(): Observable<List<TimeLineEntity>> {
        return cvRemote.getTimeLine()
    }

    override fun saveSkill(skills: List<SkillEntity>): Completable {
        throw  UnsupportedOperationException("Saving skill is not supported")
    }

    override fun cleanSkills(): Completable {
        throw  UnsupportedOperationException("Cleaning skill is not supported")
    }

    override fun getSkills(): Observable<List<SkillEntity>> {
        return cvRemote.getSkills()
    }

    override fun saveProfile(profiles: List<ProfileEntity>): Completable {
        throw  UnsupportedOperationException("Saving project is not supported")
    }

    override fun cleanProfile(): Completable {
        throw  UnsupportedOperationException("Cleaning project is not supported")
    }

    override fun getProfile(): Observable<List<ProfileEntity>> {
        return cvRemote.getProfile()
    }
}