package com.easyinc.googlesearchengine.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.easyinc.googlesearchengine.cache.model.CachedResult

@Database(
    entities = [CachedResult::class],
    version = 1,
    exportSchema = false
)
abstract class SearchDatabase: RoomDatabase() {
    abstract fun searchDao(): SearchDao
}