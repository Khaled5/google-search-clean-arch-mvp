package com.easyinc.googlesearchengine.remote

import com.easyinc.googlesearchengine.data.model.ResultEntity
import com.easyinc.googlesearchengine.data.repository.ISearchRemote
import com.easyinc.googlesearchengine.remote.mapper.ResultModelMapper
import com.easyinc.googlesearchengine.remote.service.SearchService
import io.reactivex.Single
import javax.inject.Inject

class SearchRemote @Inject constructor(
    private val searchService: SearchService,
    private val resultModelMapper: ResultModelMapper
): ISearchRemote {
    override fun search(query: String): Single<List<ResultEntity>> {
        return searchService.search(query).map { searchModel ->
            searchModel.items.map {
                resultModelMapper.mapFromModel(it)
            }
        }
    }
}