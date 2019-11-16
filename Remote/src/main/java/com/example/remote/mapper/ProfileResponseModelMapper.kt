package com.example.remote.mapper

import com.example.data.model.ProfileEntity
import com.example.remote.model.ProfileModel
import javax.inject.Inject

class ProfileResponseModelMapper @Inject constructor(): ModelMapper<ProfileModel,ProfileEntity>{

    override fun mapFromModel(model: ProfileModel): ProfileEntity {
        return ProfileEntity(model.id,model.name,model.role,model.profilepic)
    }
}