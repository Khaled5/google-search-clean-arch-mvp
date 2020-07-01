package com.easyinc.googlesearchengine.di.module

import com.easyinc.googlesearchengine.presentation.view.search.SearchFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideSearchFragment(): SearchFragment
}