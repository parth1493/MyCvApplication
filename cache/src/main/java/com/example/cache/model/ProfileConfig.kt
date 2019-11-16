package com.example.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.db.CVConfigConstants

@Entity(tableName = CVConfigConstants.PROFILE_CONFIG_TABLE_NAME)
class ProfileConfig(
    @PrimaryKey(autoGenerate = true)
    var id: Int = -1,
    var lastCacheTime: Long)