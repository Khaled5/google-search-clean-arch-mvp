package com.easyinc.googlesearchengine.presentation.view.search

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.easyinc.googlesearchengine.R
import com.easyinc.googlesearchengine.common.base.fragment.BaseFragment
import com.easyinc.googlesearchengine.presentation.presenter.MainPresenter
import com.easyinc.googlesearchengine.presentation.view.MainActivity
import kotlinx.android.synthetic.main.fragment_search.*
import javax.inject.Inject

class SearchFragment : BaseFragment() {

    @Inject lateinit var searchAdapter: SearchAdapter

    private lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainPresenter = (activity as MainActivity).presenter
        mainPresenter.getResults()

    }

    override fun layoutId(): Int {
        return R.layout.fragment_search
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecycler()

        observeResults()

        searchQuery()
    }

    private fun initRecycler(){
        search_recycler.adapter = searchAdapter
        search_recycler.layoutManager = LinearLayoutManager(context)
        search_recycler.setHasFixedSize(true)
    }

    private fun searchQuery(){
        search.setOnClickListener {
            val query = search_query.text.toString()
            if (query.isEmpty() || query.isBlank())
                search_query.error = getString(R.string.empty_error_message)
            else
                mainPresenter.search(query)
        }
    }

    private fun observeResults(){
        mainPresenter.observeResults().observe(viewLifecycleOwner, Observer {
            searchAdapter.submitList(it)
        })
    }

}