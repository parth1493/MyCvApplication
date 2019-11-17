package com.example.ui.mapper

interface UIMapper<in P, out V> {
    fun mapToView(presentation: P): V
}