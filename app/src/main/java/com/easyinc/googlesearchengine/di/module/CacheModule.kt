package com.easyinc.googlesearchengine.di.module

import android.app.Application
import androidx.room.Room
import com.easyinc.googlesearchengine.cache.SearchDao
import com.easyinc.googlesearchengine.cache.SearchDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheModule {

    @Singleton
    @Provides
    fun provideDatabase(application: Application): SearchDatabase{
        return Room
            .databaseBuilder(application,SearchDatabase::class.java, "search-db")
            .build()
    }

    @Provides
    fun provideFavouriteDao(searchDatabase: SearchDatabase): SearchDao{
        return searchDatabase.searchDao()
    }

}