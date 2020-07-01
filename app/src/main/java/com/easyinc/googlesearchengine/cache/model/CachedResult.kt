package com.easyinc.googlesearchengine.cache.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "result")
data class CachedResult(
    val link: String,
    val snippet: String,
    val title: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)