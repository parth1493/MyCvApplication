package com.example.data.store

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.repository.CVDataStore
import com.example.data.repository.CVRemote
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class CVRemoteDataStore @Inject constructor(
        private val cvRemote: CVRemote)
            :CVDataStore{
    override fun saveSkill(skills: List<SkillEntity>): Completable {
        throw  UnsupportedOperationException("Saving skill is not supported")
    }

    override fun cleanSkills(): Completable {
        throw  UnsupportedOperationException("Saving skill is not supported")
    }

    override fun getSkills(): Observable<List<SkillEntity>> {
        return cvRemote.getSkills()
    }

    override fun saveProfile(profiles: List<ProfileEntity>): Completable {
        throw  UnsupportedOperationException("Saving project is not supported")
    }

    override fun cleanProfile(): Completable {
        throw  UnsupportedOperationException("Saving project is not supported")
    }

    override fun getProfile(): Observable<List<ProfileEntity>> {
        return cvRemote.getProfile()
    }
}