package com.easyinc.googlesearchengine.presentation.mapper

import com.easyinc.googlesearchengine.domain.model.Result
import com.easyinc.googlesearchengine.presentation.model.ResultView
import javax.inject.Inject

class ResultViewMapper @Inject constructor(): ViewMapper<ResultView,Result> {
    override fun mapTo(type: Result): ResultView {
        return ResultView(
            type.link,
            type.snippet,
            type.title
        )
    }
}