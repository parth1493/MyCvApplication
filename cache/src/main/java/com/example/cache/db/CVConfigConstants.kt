package com.example.cache.db

object CVConfigConstants {
    const val PROFILE_CONFIG_TABLE_NAME = "configProfile"
    const val PROFILE_QUERY_CONFIG = "SELECT * FROM $PROFILE_CONFIG_TABLE_NAME"
    const val SKILL_CONFIG_TABLE_NAME = "configSkill"
    const val SKILL_QUERY_CONFIG = "SELECT * FROM $SKILL_CONFIG_TABLE_NAME"
    const val TIMELINE_CONFIG_TABLE_NAME = "configTimeline"
    const val TIMELINE_QUERY_CONFIG = "SELECT * FROM $TIMELINE_CONFIG_TABLE_NAME"
}