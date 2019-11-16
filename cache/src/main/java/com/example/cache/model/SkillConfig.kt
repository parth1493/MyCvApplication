package com.example.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.db.CVConfigConstants

@Entity(tableName = CVConfigConstants.SKILL_CONFIG_TABLE_NAME)
class SkillConfig(
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,
    var lastCacheTime: Long)