package com.easyinc.googlesearchengine.cache.mapper

import com.easyinc.googlesearchengine.cache.model.CachedResult
import com.easyinc.googlesearchengine.data.model.ResultEntity
import javax.inject.Inject

class CachedResultsMapper @Inject constructor(): CacheMapper<CachedResult,ResultEntity> {
    override fun mapFromCache(cache: CachedResult): ResultEntity {
        return ResultEntity(
            cache.link,
            cache.snippet,
            cache.title
        )
    }

    override fun mapToCache(entity: ResultEntity): CachedResult {
        return CachedResult(
            entity.link,
            entity.snippet,
            entity.title
        )
    }
}