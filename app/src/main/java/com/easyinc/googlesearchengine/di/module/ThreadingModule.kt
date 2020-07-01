package com.easyinc.googlesearchengine.di.module

import com.easyinc.googlesearchengine.common.base.usecase.JobExecutor
import com.easyinc.googlesearchengine.common.base.usecase.PostExecutionThread
import com.easyinc.googlesearchengine.common.base.usecase.ThreadExecutor
import com.easyinc.googlesearchengine.common.base.usecase.UiThread
import dagger.Binds
import dagger.Module

@Module
abstract class ThreadingModule {

    @Binds
    abstract fun bindPostExecutionThread(uiThread: UiThread): PostExecutionThread

    @Binds
    abstract fun bindThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor

}