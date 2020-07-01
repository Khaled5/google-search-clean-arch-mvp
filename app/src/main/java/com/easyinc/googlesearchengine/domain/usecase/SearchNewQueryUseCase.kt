package com.easyinc.googlesearchengine.domain.usecase

import android.accounts.NetworkErrorException
import com.easyinc.googlesearchengine.common.base.usecase.CompletableUseCase
import com.easyinc.googlesearchengine.common.base.usecase.PostExecutionThread
import com.easyinc.googlesearchengine.common.base.usecase.ThreadExecutor
import com.easyinc.googlesearchengine.common.network_state.NetworkStateHolder
import com.easyinc.googlesearchengine.domain.ISearchRepository
import io.reactivex.Completable
import javax.inject.Inject

class SearchNewQueryUseCase @Inject constructor(
    private val searchRepository: ISearchRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
): CompletableUseCase<String>(threadExecutor,postExecutionThread) {

    override fun buildUseCaseObservable(params: String?): Completable {

        if (NetworkStateHolder.isConnected) {
            return searchRepository.search(params!!)
        }else{
            throw NetworkErrorException("Check you internet connection!")
        }

    }

}