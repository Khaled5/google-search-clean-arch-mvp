package com.easyinc.googlesearchengine

import com.easyinc.googlesearchengine.common.network_state.NetworkStateHolder.registerConnectivityBroadcaster
import com.easyinc.googlesearchengine.di.DaggerMainComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class SearchApp: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerMainComponent.builder().application(this).build()
    }

    override fun onCreate() {
        super.onCreate()
        registerConnectivityBroadcaster()
    }
}