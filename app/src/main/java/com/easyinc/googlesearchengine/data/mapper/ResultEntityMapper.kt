package com.easyinc.googlesearchengine.data.mapper

import com.easyinc.googlesearchengine.data.model.ResultEntity
import com.easyinc.googlesearchengine.domain.model.Result
import javax.inject.Inject

class ResultEntityMapper @Inject constructor(): EntityMapper<ResultEntity,Result> {
    override fun mapFrom(entity: ResultEntity): Result {
        return Result(
            entity.link,
            entity.snippet,
            entity.title
        )
    }

    override fun mapTo(entity: Result): ResultEntity {
        return ResultEntity(
            entity.link,
            entity.snippet,
            entity.title
        )
    }
}