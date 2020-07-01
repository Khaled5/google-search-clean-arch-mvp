package com.easyinc.googlesearchengine.data.store

import com.easyinc.googlesearchengine.data.model.ResultEntity
import com.easyinc.googlesearchengine.data.repository.ISearchDataStore
import com.easyinc.googlesearchengine.data.repository.ISearchRemote
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class SearchRemoteDataStore @Inject constructor(
    private val searchRemote: ISearchRemote
): ISearchDataStore {
    override fun saveNewCache(results: List<ResultEntity>): Completable {
        throw UnsupportedOperationException("Saving cache isn't supported here...")
    }

    override fun deletePreviousCache(): Completable {
        throw UnsupportedOperationException("Deleting cache isn't supported here...")
    }

    override fun getCachedResults(): Observable<List<ResultEntity>> {
        throw UnsupportedOperationException("Fetching cache isn't supported here...")
    }

    override fun searchQuery(query: String): Single<List<ResultEntity>> {
        return searchRemote.search(query)
    }
}