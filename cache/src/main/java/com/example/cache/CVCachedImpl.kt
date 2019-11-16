package com.example.cache

import com.example.cache.db.CVDatabase
import com.example.cache.mapper.CachedProfileMapper
import com.example.cache.mapper.CachedSkillMapper
import com.example.cache.mapper.CachedTimelineMapper
import com.example.cache.model.ProfileConfig
import com.example.cache.model.SkillConfig
import com.example.cache.model.TimelineConfig
import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.repository.CVCache
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class CVCachedImpl @Inject constructor(
    private val cvDatabase:CVDatabase,
    private val cachedProfileMapper: CachedProfileMapper,
    private val cachedSkillMapper: CachedSkillMapper,
    private val cachedTimelineMapper: CachedTimelineMapper)
    :CVCache{
    override fun clearProfile(): Completable {
        return Completable.defer {
            cvDatabase.cachedProfileDao().deleteProfile()
            Completable.complete()
        }
    }

    override fun saveProfile(profiles: List<ProfileEntity>): Completable {
        return Completable.defer {
            cvDatabase.cachedProfileDao().insertProfile(
                profiles.map { cachedProfileMapper.mapToCached(it) }
            )
            Completable.complete()
        }
    }

    override fun getProfile(): Observable<List<ProfileEntity>> {
        return cvDatabase.cachedProfileDao().getProfile()
            .toObservable()
            .map {
                it.map { cachedProfileMapper.mapFromCached(it) }
        }
    }

    override fun isProfileCached(): Single<Boolean> {
        return cvDatabase.cachedProfileDao().getProfile().isEmpty
            .map { !it }
    }

    override fun setProfileLastCachedTime(lastCache: Long): Completable {
        return Completable.defer {
            cvDatabase.profileConfigDao().insertConfig(ProfileConfig(lastCacheTime = lastCache))
            Completable.complete()
        }
    }

    override fun isProfileCachedExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return cvDatabase.profileConfigDao()
            .getConfig()
            .onErrorReturn {ProfileConfig(lastCacheTime = 0) }
            .single(ProfileConfig(lastCacheTime = 0))
            .map {
                currentTime - it.lastCacheTime > expirationTime
        }
    }

    override fun cleanSkillS(): Completable {
        return Completable.defer {
            cvDatabase.cachedSkillDao().deleteSkill()
            Completable.complete()
        }
    }

    override fun saveSkills(skills: List<SkillEntity>): Completable {
        return Completable.defer {
            cvDatabase.cachedSkillDao().insertSkill(
                skills.map { cachedSkillMapper.mapToCached(it) }
            )
            Completable.complete()
        }
    }

    override fun getSkillS(): Observable<List<SkillEntity>> {
        return cvDatabase.cachedSkillDao().getSkill()
            .toObservable()
            .map {
                it.map { cachedSkillMapper.mapFromCached(it) }
        }
    }

    override fun isSkillCached(): Single<Boolean> {
        return cvDatabase.cachedSkillDao().getSkill().isEmpty
            .map { !it }
    }

    override fun setSkillsLastCachedTime(lastCache: Long): Completable {
        return Completable.defer {
            cvDatabase.skillConfigDao().insertConfig(SkillConfig(lastCacheTime = lastCache))
            Completable.complete()
        }
    }

    override fun isSkillCachedExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return cvDatabase.skillConfigDao().getConfig()
            .single(SkillConfig(lastCacheTime = 0))
            .map {
                currentTime - it.lastCacheTime > expirationTime
        }
    }

    override fun clearTimeLine(): Completable {
        return Completable.defer {
            cvDatabase.cachedTimelineDao().deleteTimeline()
            Completable.complete()
        }
    }

    override fun saveTimeLine(timeLine: List<TimeLineEntity>): Completable {
        return Completable.defer {
            cvDatabase.cachedTimelineDao().insertTimeline(
                timeLine.map { cachedTimelineMapper.mapToCached(it) }
            )
            Completable.complete()
        }
    }

    override fun getTimeLine(): Observable<List<TimeLineEntity>> {
        return cvDatabase.cachedTimelineDao().getTimeline()
            .toObservable()
            .map {
                it.map { cachedTimelineMapper.mapFromCached(it) }
        }
    }

    override fun isTimeLineCached(): Single<Boolean> {
        return cvDatabase.cachedTimelineDao().getTimeline().isEmpty
            .map { !it }
    }

    override fun setTimeLineLastCachedTime(lastCache: Long): Completable {
        return Completable.defer {
            cvDatabase.timelineConfigDao().insertConfig(TimelineConfig(lastCacheTime = lastCache))
            Completable.complete()
        }
    }

    override fun isTimeLineCachedExpired(): Single<Boolean> {
        val currentTime = System.currentTimeMillis()
        val expirationTime = (60 * 10 * 1000).toLong()
        return cvDatabase.timelineConfigDao().getConfig()
            .single(TimelineConfig(lastCacheTime = 0))
            .map {
                currentTime - it.lastCacheTime > expirationTime
        }
    }
}