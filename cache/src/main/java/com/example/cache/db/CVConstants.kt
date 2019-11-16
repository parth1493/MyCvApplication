package com.example.cache.db

object CVConstants {
    const val PROFILE_TABLE_NAME = "profile"
    const val SKILL_TABLE_NAME = "skills"
    const val TIMELINE_TABLE_NAME = "timeline"
    const val QUERY_PROFILE = "SELECT * FROM $PROFILE_TABLE_NAME"
    const val QUERY_SKILL = "SELECT * FROM $SKILL_TABLE_NAME"
    const val QUERY_TIMELINE = "SELECT * FROM $TIMELINE_TABLE_NAME"
    const val DELETE_QUERY_PROFILE = "DELETE FROM $PROFILE_TABLE_NAME"
    const val DELETE_QUERY_SKILL = "DELETE FROM $SKILL_TABLE_NAME"
    const val DELETE_QUERY_TIMELINE = "DELETE FROM $TIMELINE_TABLE_NAME"

}