package com.easyinc.googlesearchengine.remote.service

import com.easyinc.googlesearchengine.BuildConfig
import com.easyinc.googlesearchengine.remote.model.SearchModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface SearchService {

    @GET("customsearch/v1?")
    fun search(
        @Query("q") query : String,
        @Query("key") token: String = BuildConfig.ApiKey,
        @Query("cx") cx: String = SEARCH_ENGINE_ID,
        @Query("num") num : Int = RESULT_NUMBER
    ): Single<SearchModel>


    companion object{
        private const val SEARCH_ENGINE_ID = "013036536707430787589:_pqjad5hr1a"
        private const val RESULT_NUMBER = 10
    }
}