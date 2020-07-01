package com.easyinc.googlesearchengine.presentation.presenter

import androidx.lifecycle.LiveData
import com.easyinc.googlesearchengine.common.Resource
import com.easyinc.googlesearchengine.common.base.presenter.BasePresenter
import com.easyinc.googlesearchengine.domain.usecase.GetResultsUseCase
import com.easyinc.googlesearchengine.domain.usecase.SearchNewQueryUseCase
import com.easyinc.googlesearchengine.presentation.mapper.ResultViewMapper
import com.easyinc.googlesearchengine.presentation.model.ResultView
import java.lang.Exception
import javax.inject.Inject

class MainPresenter @Inject constructor(
    private val getResultsUseCase: GetResultsUseCase,
    private val searchNewQueryUseCase: SearchNewQueryUseCase,
    private val resultViewMapper: ResultViewMapper
) : BasePresenter() {

    fun observeResults(): LiveData<List<ResultView>>{
        return resultLiveData
    }

    fun search(query: String){
        try {
            disposables.add(
                searchNewQueryUseCase.execute(query).doOnSubscribe {
                    messageLiveData.value = Resource.Loading(null)
                }.subscribe(
                    {
                        messageLiveData.value = Resource.Success("")
                    },{
                        messageLiveData.value = Resource.Error(it.message!!)
                    }
                )
            )
        }catch (e: Exception){
            messageLiveData.value = Resource.Error(e.message!!)
        }

    }

    fun getResults(){
        disposables.add(
            getResultsUseCase.execute().doOnSubscribe {
                messageLiveData.value = Resource.Loading(null)
            }.subscribe(
                {
                    resultLiveData.value = it.map {result ->
                        resultViewMapper.mapTo(result)
                    }

                    messageLiveData.value = Resource.Success("")
                },{
                    messageLiveData.value = Resource.Error(it.message!!)
                }
            )
        )
    }
}