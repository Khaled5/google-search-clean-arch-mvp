package com.easyinc.googlesearchengine.common.base.presenter

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.easyinc.googlesearchengine.common.Resource
import com.easyinc.googlesearchengine.presentation.model.ResultView
import io.reactivex.disposables.CompositeDisposable

abstract class BasePresenter : LifecycleObserver {

    val disposables = CompositeDisposable()
    val resultLiveData = MutableLiveData<List<ResultView>>()
    val messageLiveData = MutableLiveData<Resource<String>>()

    fun attachLifecycle(lifecycle: Lifecycle) {
        lifecycle.addObserver(this)
    }

    fun detachLifecycle(lifecycle: Lifecycle) {
        lifecycle.removeObserver(this)
    }

    @OnLifecycleEvent(value = Lifecycle.Event.ON_DESTROY)
    fun onPresenterDestroy() {
        disposables.clear()
    }
}