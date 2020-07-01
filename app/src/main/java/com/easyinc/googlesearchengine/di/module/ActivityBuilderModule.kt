package com.easyinc.googlesearchengine.di.module

import com.easyinc.googlesearchengine.presentation.view.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @ContributesAndroidInjector
    abstract fun provideMainActivity(): MainActivity

}