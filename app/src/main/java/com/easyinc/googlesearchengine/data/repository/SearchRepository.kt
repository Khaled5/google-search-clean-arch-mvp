package com.easyinc.googlesearchengine.data.repository

import com.easyinc.googlesearchengine.data.mapper.ResultEntityMapper
import com.easyinc.googlesearchengine.data.store.SearchCacheDataStore
import com.easyinc.googlesearchengine.data.store.SearchRemoteDataStore
import com.easyinc.googlesearchengine.domain.ISearchRepository
import com.easyinc.googlesearchengine.domain.model.Result
import io.reactivex.Completable
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class SearchRepository @Inject constructor(
    private val searchCacheDataStore: SearchCacheDataStore,
    private val searchRemoteDataStore: SearchRemoteDataStore,
    private val resultEntityMapper: ResultEntityMapper
): ISearchRepository {

    override fun search(query: String): Completable {
        return searchRemoteDataStore.searchQuery(query)
            .flatMap {
                searchCacheDataStore.deletePreviousCache().andThen(Single.just(it))
            }
            .flatMapCompletable {resultsList ->
                searchCacheDataStore.saveNewCache(resultsList)
            }
    }

    override fun getResults(): Observable<List<Result>> {
        return searchCacheDataStore.getCachedResults().map {resultList ->
            resultList.map {
                resultEntityMapper.mapFrom(it)
            }
        }
    }

}