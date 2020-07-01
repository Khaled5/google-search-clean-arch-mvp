package com.easyinc.googlesearchengine.presentation.view

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import com.easyinc.googlesearchengine.R
import com.easyinc.googlesearchengine.common.Resource
import com.easyinc.googlesearchengine.common.base.activity.BaseActivity
import com.easyinc.googlesearchengine.common.extention.snack
import com.easyinc.googlesearchengine.presentation.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<MainPresenter>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observeRequestState()

    }

    private fun observeRequestState(){
        presenter.messageLiveData.observe(this, Observer {
            when(it.status){
                Resource.Status.SUCCESS -> showLoading(false)
                Resource.Status.ERROR -> {
                    showLoading(false)
                    it.message?.let { message -> showSnackBar(message) }
                }
                Resource.Status.LOADING -> showLoading(true)
            }
        })
    }

    private fun showLoading(show: Boolean){
        loading_layout.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun showSnackBar(message: String){
        main_constraint.snack(message)
    }

}