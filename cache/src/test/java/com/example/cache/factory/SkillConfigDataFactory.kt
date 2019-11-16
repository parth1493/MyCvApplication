package com.example.cache.factory;

import com.example.cache.model.SkillConfig


object SkillConfigDataFactory {
    fun makeCachedConfig(): SkillConfig {
        return SkillConfig(-1, DataFactory.randomLong())
    }
}