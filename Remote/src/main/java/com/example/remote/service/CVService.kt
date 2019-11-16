package com.example.remote.service

import com.example.remote.model.*
import io.reactivex.Observable
import retrofit2.http.GET

interface CVService {
    @GET("parth1493/af2ed19fe266349509435dff7d2126a8/raw/8f7ec084aa91c7da25593424843eacd981c53d99")
    fun getSkills(): Observable<SkillResposeModel>

    @GET("parth1493/26737d689ede79bf5cd58a0e63f404a6/raw/3e2478f7326e9fa6bea2302d607f20ef8bed06dc")
    fun getProfile(): Observable<ProfileResposeModel>

    @GET("parth1493/e96e21174bfefcffb58f11288c34605c/raw/00e74f63c8b7e9ec3cf8eeb23e1a6196fa0954d5")
    fun getTimeLine(): Observable<TimelineResposeModel>
}