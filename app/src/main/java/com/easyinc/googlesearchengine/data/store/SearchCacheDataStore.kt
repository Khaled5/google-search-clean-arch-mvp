package com.easyinc.googlesearchengine.data.store

import com.easyinc.googlesearchengine.data.model.ResultEntity
import com.easyinc.googlesearchengine.data.repository.ISearchCache
import com.easyinc.googlesearchengine.data.repository.ISearchDataStore
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class SearchCacheDataStore @Inject constructor(
    private val searchCache: ISearchCache
): ISearchDataStore {
    override fun saveNewCache(results: List<ResultEntity>): Completable {
        return searchCache.saveNew(results)
    }

    override fun deletePreviousCache(): Completable {
        return searchCache.deletePrevious()
    }

    override fun getCachedResults(): Observable<List<ResultEntity>> {
        return searchCache.getResults()
    }

    override fun searchQuery(query: String): Single<List<ResultEntity>> {
        throw UnsupportedOperationException("Searching isn't supported here...")
    }
}