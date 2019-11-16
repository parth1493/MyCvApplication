package com.example.data

import com.example.data.mapper.ProfileMapper
import com.example.data.mapper.SkillMapper
import com.example.data.mapper.TimeLineMapper
import com.example.data.repository.CVCache
import com.example.data.store.CVDataStoreFactory
import com.example.domain.model.Profile
import com.example.domain.model.Skill
import com.example.domain.model.Timeline
import com.example.domain.respository.CVRepository
import io.reactivex.Observable
import io.reactivex.functions.BiFunction
import javax.inject.Inject

class CVDataRepository @Inject constructor(
    private val mapperProfile : ProfileMapper,
    private val mapperSkill : SkillMapper,
    private val mapperTimeLine : TimeLineMapper,
    private val cache : CVCache,
    private val factory : CVDataStoreFactory ):CVRepository {

    override fun getTimeLine(): Observable<List<Timeline>> {
        return Observable.zip(cache.isTimeLineCached().toObservable(),
            cache.isTimeLineCachedExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> {
                    isCached, isExpired -> Pair(isCached, isExpired)
            })
            .flatMap {
                factory.getDataStore(it.first, it.second).getTimeLine()
            }
            .flatMap {
                    skill -> factory.getCacheDataStore()
                .saveTimeLine(skill)
                .andThen(Observable.just(skill))
            }
            .map {
                it.map {
                    mapperTimeLine.mapFromEntity(it)
            }
        }
    }

    override fun getSkill(): Observable<List<Skill>> {

        return Observable.zip(cache.isSkillCached().toObservable(),
            cache.isSkillCachedExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> {
                    isCached, isExpired -> Pair(isCached, isExpired)
            })
            .flatMap {
                factory.getDataStore(it.first, it.second).getSkills()
            }
            .flatMap {
                    skill -> factory.getCacheDataStore()
                .saveSkill(skill)
                .andThen(Observable.just(skill))
            }
            .map {
                it.map {
                    mapperSkill.mapFromEntity(it)
            }
        }
    }

    override fun getProfile(): Observable<List<Profile>> {
        return Observable.zip(cache.isProfileCached().toObservable(),
            cache.isProfileCachedExpired().toObservable(),
            BiFunction<Boolean, Boolean, Pair<Boolean, Boolean>> {
                    isCached, isExpired -> Pair(isCached, isExpired)
            })
            .flatMap {
                factory.getDataStore(it.first, it.second).getProfile()
            }
            .flatMap {
                    profile -> factory.getCacheDataStore()
                .saveProfile(profile)
                .andThen(Observable.just(profile))
            }
            .map {
                it.map {
                    mapperProfile.mapFromEntity(it)
            }
        }
    }
}