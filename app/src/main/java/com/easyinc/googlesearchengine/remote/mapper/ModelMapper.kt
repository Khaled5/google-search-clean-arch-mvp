package com.easyinc.googlesearchengine.remote.mapper

interface ModelMapper< M, E> {

    fun mapFromModel(model: M) : E

    fun mapToModel(entity: E): M
}