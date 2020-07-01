package com.easyinc.googlesearchengine.di

import android.app.Application
import com.easyinc.googlesearchengine.SearchApp
import com.easyinc.googlesearchengine.di.module.*
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton


@Singleton
@Component(modules = [
    AndroidSupportInjectionModule::class,
    AppModule::class,
    CacheModule::class,
    RemoteModule::class,
    RepositoryModule::class,
    ActivityBuilderModule::class,
    FragmentBuilderModule::class,
    ThreadingModule::class]
)
interface MainComponent  : AndroidInjector<SearchApp> {


    @Component.Builder
    interface Builder{

        @BindsInstance
        fun application(application: Application): Builder

        fun build(): MainComponent

    }

}