package com.example.ui.mapper

import com.example.presentation.model.ProfileView
import com.example.ui.model.UIProfile
import javax.inject.Inject

class UIProfileMapper @Inject constructor(): UIMapper<ProfileView, UIProfile> {
    override fun mapToView(presentation: ProfileView): UIProfile {
        return  UIProfile(presentation.id,presentation.name,presentation.role,presentation.profilepic)
    }
}