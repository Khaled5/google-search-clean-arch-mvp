package com.easyinc.googlesearchengine.remote.mapper

import com.easyinc.googlesearchengine.data.model.ResultEntity
import com.easyinc.googlesearchengine.remote.model.ResultModel
import javax.inject.Inject

class ResultModelMapper @Inject constructor(): ModelMapper<ResultModel,ResultEntity> {
    override fun mapFromModel(model: ResultModel): ResultEntity {
        return ResultEntity(
            model.link,
            model.snippet,
            model.title
        )
    }

    override fun mapToModel(entity: ResultEntity): ResultModel {
        return ResultModel(
            entity.link,
            entity.snippet,
            entity.title
        )
    }
}