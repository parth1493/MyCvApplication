package com.example.cache.mapper

interface CacherMapper<C, E> {
    fun mapFromCached(type: C): E
    fun mapToCached(type: E): C
}