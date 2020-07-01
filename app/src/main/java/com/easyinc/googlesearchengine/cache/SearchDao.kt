package com.easyinc.googlesearchengine.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.easyinc.googlesearchengine.cache.model.CachedResult
import io.reactivex.Observable

@Dao
interface SearchDao {

    @Insert
    fun insertAllResults(list: List<CachedResult>)

    @Query("SELECT * FROM result ORDER BY id")
    fun getAllResults(): Observable<List<CachedResult>>

    @Query("DELETE FROM result")
    fun deleteAllPreviousResults()

}