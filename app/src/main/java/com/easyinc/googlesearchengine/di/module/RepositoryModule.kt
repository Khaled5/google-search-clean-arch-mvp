package com.easyinc.googlesearchengine.di.module

import com.easyinc.googlesearchengine.cache.SearchCache
import com.easyinc.googlesearchengine.data.repository.ISearchCache
import com.easyinc.googlesearchengine.data.repository.ISearchRemote
import com.easyinc.googlesearchengine.data.repository.SearchRepository
import com.easyinc.googlesearchengine.domain.ISearchRepository
import com.easyinc.googlesearchengine.remote.SearchRemote
import dagger.Binds
import dagger.Module

@Module
abstract class RepositoryModule {


    @Binds
    abstract fun provideSearchCache(searchCache: SearchCache): ISearchCache

    @Binds
    abstract fun provideSearchRemote(searchRemote: SearchRemote): ISearchRemote

    @Binds
    abstract fun provideSearchRepository(searchRepository: SearchRepository): ISearchRepository

}