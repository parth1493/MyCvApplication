package com.example.presentation.mapper

import com.example.domain.model.Profile
import com.example.presentation.model.ProfileView
import javax.inject.Inject

open class ProfileViewMapper @Inject constructor():Mapper<ProfileView,Profile> {

    override fun mapToView(entity: Profile): ProfileView {
        return  ProfileView(entity.id,entity.name,entity.role,entity.profilepic)
    }
}