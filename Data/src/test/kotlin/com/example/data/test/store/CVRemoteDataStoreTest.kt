package com.example.data.test.store

import com.example.data.model.ProfileEntity
import com.example.data.model.SkillEntity
import com.example.data.repository.CVRemote
import com.example.data.store.CVRemoteDataStore
import com.example.data.test.CVFactory
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Test

class CVRemoteDataStoreTest {

    private val remote = mock<CVRemote>()
    private val store = CVRemoteDataStore(remote)

    @Test
    fun getProfileCompletes() {
        stubRemoteGetProfile(Observable.just(listOf(CVFactory.makeProfileEntity())))
        val testObserver = store.getProfile().test()
        testObserver.assertComplete()
    }

    @Test
    fun getProfileReturnsData() {
        val data = listOf(CVFactory.makeProfileEntity())
        stubRemoteGetProfile(Observable.just(data))
        val testObserver = store.getProfile().test()
        testObserver.assertValue(data)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveProfileThrowsException() {
        store.saveProfile(listOf()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearProfileThrowsException() {
        store.cleanProfile().test()
    }

    private fun stubRemoteGetProfile(observable: Observable<List<ProfileEntity>>) {
        whenever(remote.getProfile())
            .thenReturn(observable)
    }

    @Test
    fun getSkillCompletes() {
        stubRemoteGetSkill(Observable.just(listOf(CVFactory.makeSkillEntity())))
        val testObserver = store.getSkills().test()
        testObserver.assertComplete()
    }

    @Test
    fun getSkillReturnsData() {
        val data = listOf(CVFactory.makeSkillEntity())
        stubRemoteGetSkill(Observable.just(data))
        val testObserver = store.getSkills().test()
        testObserver.assertValue(data)
    }

    @Test(expected = UnsupportedOperationException::class)
    fun saveSkillThrowsException() {
        store.saveSkill(listOf()).test()
    }

    @Test(expected = UnsupportedOperationException::class)
    fun clearSkillThrowsException() {
        store.cleanSkills().test()
    }

    private fun stubRemoteGetSkill(observable: Observable<List<SkillEntity>>) {
        whenever(remote.getSkills())
            .thenReturn(observable)
    }
}