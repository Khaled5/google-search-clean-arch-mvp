package com.easyinc.googlesearchengine.common.base.activity

import android.os.Bundle
import android.os.PersistableBundle
import androidx.lifecycle.LifecycleRegistry
import com.easyinc.googlesearchengine.common.base.presenter.BasePresenter
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

open class BaseActivity< p : BasePresenter>: DaggerAppCompatActivity() {

    @Suppress("LeakingThis")
    private val lifecycleRegistry : LifecycleRegistry = LifecycleRegistry(this)

    @Inject
    lateinit var presenter: p

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        presenter.attachLifecycle(lifecycleRegistry)
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachLifecycle(lifecycleRegistry)
    }

}