package com.example.cache.factory;

import com.example.cache.model.ProfileConfig
import com.example.cache.model.TimelineConfig


object TimelineConfigDataFactory {
    fun makeCachedConfig(): TimelineConfig {
        return TimelineConfig(-1, DataFactory.randomLong())
    }
}