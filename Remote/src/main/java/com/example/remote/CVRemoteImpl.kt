package com.example.remote

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.model.TimeLineEntity
import com.example.data.repository.CVRemote
import com.example.remote.mapper.ProfileResponseModelMapper
import com.example.remote.mapper.SkillResponseModelMapper
import com.example.remote.mapper.TimelineResponseModelMapper
import com.example.remote.service.CVService
import io.reactivex.Observable
import javax.inject.Inject

class CVRemoteImpl @Inject constructor(
    private val service: CVService,
    private val profileMapper: ProfileResponseModelMapper,
    private val skillMapper: SkillResponseModelMapper,
    private val timeLineMapper: TimelineResponseModelMapper)
    : CVRemote{
    override fun getProfile(): Observable<List<ProfileEntity>> {
        return service.getProfile()
            .map { it.items.map { profileMapper.mapFromModel(it) } }
    }

    override fun getSkills(): Observable<List<SkillEntity>> {
        return service.getSkills()
            .map { it.items.map { skillMapper.mapFromModel(it) } }
    }

    override fun getTimeLine(): Observable<List<TimeLineEntity>> {
        return service.getTimeLine()
            .map { it.items.map { timeLineMapper.mapFromModel(it) } }
    }
}