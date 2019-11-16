package com.example.data.mapper

import com.example.data.model.ProfileEntity
import com.example.domain.model.Profile
import javax.inject.Inject

class ProfileMapper @Inject constructor(): EntityMapper<ProfileEntity,Profile>{

    override fun mapFromEntity(entity: ProfileEntity): Profile {
        return  Profile(entity.id,entity.name,entity.role,entity.profilepic)
    }

    override fun mapToEntity(domain: Profile): ProfileEntity {
        return  ProfileEntity(domain.id,domain.name,domain.role,domain.profilepic)
    }
}