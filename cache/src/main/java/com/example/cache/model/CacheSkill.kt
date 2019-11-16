package com.example.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.db.CVConstants
import java.io.Serializable

@Entity(tableName = CVConstants.SKILL_TABLE_NAME)
 data class CacheSkill(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id:Int,
    @ColumnInfo(name = "skillname")
    var skillname: String,
    @ColumnInfo(name = "skillValue")
    var skillValue : Float = 0.0f)
