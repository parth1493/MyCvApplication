package com.example.cache.factory;

import com.example.cache.model.ProfileConfig


object ProfileConfigDataFactory {
    fun makeCachedConfig(): ProfileConfig {
        return ProfileConfig(-1, DataFactory.randomLong())
    }
}