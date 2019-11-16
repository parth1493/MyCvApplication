package com.example.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.db.CVConstants

@Entity(tableName = CVConstants.PROFILE_TABLE_NAME)
data class CacheProfile(
    @PrimaryKey
    @ColumnInfo(name = "id")
    var id:Int,
    @ColumnInfo(name = "name")
    var name:String,
    @ColumnInfo(name = "role")
    var role:String,
    @ColumnInfo(name = "profilepic")
    var profilepic:String)