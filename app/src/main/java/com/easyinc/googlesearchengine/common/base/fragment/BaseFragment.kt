package com.easyinc.googlesearchengine.common.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import dagger.android.support.DaggerFragment

abstract class BaseFragment: DaggerFragment() {

    var isConnected: Boolean = false

    lateinit var navController: NavController
    
    abstract fun layoutId(): Int

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        /*NetworkEvents.observe(viewLifecycleOwner, Observer {
            isConnected = it.state.isConnected
        })*/

        return inflater.inflate(layoutId(), container, false)
    }


    fun showLoading(show: Boolean){
        //(activity as MainActivity).showLoading(show)
    }


}