package com.easyinc.googlesearchengine.cache

import com.easyinc.googlesearchengine.cache.mapper.CachedResultsMapper
import com.easyinc.googlesearchengine.data.model.ResultEntity
import com.easyinc.googlesearchengine.data.repository.ISearchCache
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class SearchCache @Inject constructor(
    private val searchDao: SearchDao,
    private val cachedResultsMapper: CachedResultsMapper
): ISearchCache {
    override fun saveNew(results: List<ResultEntity>): Completable {
        return  Completable.defer {
            searchDao.insertAllResults(
                results.map {
                    cachedResultsMapper.mapToCache(it)
                }
            )
            Completable.complete()
        }
    }

    override fun deletePrevious(): Completable {
        return  Completable.defer {
            searchDao.deleteAllPreviousResults()
            Completable.complete()
        }
    }

    override fun getResults(): Observable<List<ResultEntity>> {
        return searchDao.getAllResults().map { cachedResultsList ->
            cachedResultsList.map {
                cachedResultsMapper.mapFromCache(it)
            }
        }
    }


}