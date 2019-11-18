package com.example.remote.service

import com.example.remote.model.*
import io.reactivex.Observable
import retrofit2.http.GET

interface CVService {
    @GET("parth1493/af2ed19fe266349509435dff7d2126a8/raw/726c4e2c8e3006a34e46e92778e555f05d72f7d4")
    fun getSkills(): Observable<SkillResposeModel>

    @GET("parth1493/26737d689ede79bf5cd58a0e63f404a6/raw/3262587709c7bcd5c8224ce0c74eb958601bbd84")
    fun getProfile(): Observable<ProfileResposeModel>

    @GET("parth1493/e96e21174bfefcffb58f11288c34605c/raw/81c2614951424e310c421b1b2f2aaee24b506efa")
    fun getTimeLine(): Observable<TimelineResposeModel>
}