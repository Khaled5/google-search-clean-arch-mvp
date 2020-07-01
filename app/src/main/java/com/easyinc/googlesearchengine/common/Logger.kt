package com.easyinc.googlesearchengine.common

import android.util.Log

object Logger {

    private const val TAG = "Search"

    fun dt(value: String) {
        Log.d(TAG, "Thread Name: ${Thread.currentThread().name} - $value")
    }
}