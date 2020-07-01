package com.easyinc.googlesearchengine.domain

import com.easyinc.googlesearchengine.domain.model.Result
import io.reactivex.Completable
import io.reactivex.Observable

interface ISearchRepository {
    fun search(query: String): Completable

    fun getResults(): Observable<List<Result>>
}