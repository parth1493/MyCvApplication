package com.example.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.cache.db.CVConstants
import java.io.Serializable

@Entity(tableName = CVConstants.TIMELINE_TABLE_NAME)
data class CacheTimeline(
     @PrimaryKey
     @ColumnInfo(name = "id")
     var id: Int,
     @ColumnInfo(name = "name")
     var name: String,
     @ColumnInfo(name = "roleName")
     var roleName: String,
     @ColumnInfo(name = "dateToFrom")
     var dateToFrom: String,
     @ColumnInfo(name = "image")
     var image: String,
     @ColumnInfo(name = "responsibilities")
     var responsibilities: String,
     @ColumnInfo(name = "Int")
     var timeLineState: Int):Serializable


