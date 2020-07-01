package com.easyinc.googlesearchengine.data.repository

import com.easyinc.googlesearchengine.data.model.ResultEntity
import io.reactivex.Completable
import io.reactivex.Observable

interface ISearchCache {
    fun saveNew(results: List<ResultEntity>): Completable

    fun deletePrevious(): Completable

    fun getResults(): Observable<List<ResultEntity>>
}