package com.example.cache.mapper

import com.example.cache.model.CacheProfile
import com.example.data.model.ProfileEntity
import javax.inject.Inject

class CachedProfileMapper @Inject constructor():CacherMapper<CacheProfile, ProfileEntity> {

    override fun mapFromCached(model: CacheProfile): ProfileEntity {
        return ProfileEntity(model.id,model.name,model.role,model.profilepic)
    }

    override fun mapToCached(model: ProfileEntity): CacheProfile {
        return CacheProfile(model.id,model.name,model.role,model.profilepic)
    }
}