package com.easyinc.googlesearchengine.presentation.mapper

interface ViewMapper<out V, in D> {

    fun mapTo(type: D): V
}