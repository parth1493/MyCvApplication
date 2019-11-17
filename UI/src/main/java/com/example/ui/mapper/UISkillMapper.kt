package com.example.ui.mapper

import com.example.domain.model.Skill
import com.example.presentation.model.SkillView
import com.example.ui.model.UISkill
import javax.inject.Inject

class UISkillMapper @Inject constructor(): UIMapper<SkillView, UISkill> {
    override fun mapToView(presentation: SkillView): UISkill {
        return UISkill(presentation.id,presentation.skillname,presentation.skillValue)
    }
}