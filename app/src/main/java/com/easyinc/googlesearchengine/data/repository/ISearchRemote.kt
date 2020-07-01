package com.easyinc.googlesearchengine.data.repository

import com.easyinc.googlesearchengine.data.model.ResultEntity
import io.reactivex.Single

interface ISearchRemote {

    fun search(query: String): Single<List<ResultEntity>>

}