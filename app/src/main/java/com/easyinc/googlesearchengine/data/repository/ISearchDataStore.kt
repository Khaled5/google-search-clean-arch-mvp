package com.easyinc.googlesearchengine.data.repository

import com.easyinc.googlesearchengine.data.model.ResultEntity
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single

interface ISearchDataStore {
    fun saveNewCache(results: List<ResultEntity>): Completable

    fun deletePreviousCache(): Completable

    fun getCachedResults(): Observable<List<ResultEntity>>

    fun searchQuery(query: String): Single<List<ResultEntity>>
}