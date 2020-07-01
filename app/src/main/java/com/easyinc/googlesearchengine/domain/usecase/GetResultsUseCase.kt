package com.easyinc.googlesearchengine.domain.usecase

import com.easyinc.googlesearchengine.common.base.usecase.ObservableUseCase
import com.easyinc.googlesearchengine.common.base.usecase.PostExecutionThread
import com.easyinc.googlesearchengine.common.base.usecase.ThreadExecutor
import com.easyinc.googlesearchengine.domain.ISearchRepository
import com.easyinc.googlesearchengine.domain.model.Result
import io.reactivex.Observable
import javax.inject.Inject

class GetResultsUseCase @Inject constructor(
    private val searchRepository: ISearchRepository,
    threadExecutor: ThreadExecutor,
    postExecutionThread: PostExecutionThread
): ObservableUseCase<List<Result>, Unit>(
    threadExecutor,
    postExecutionThread
) {

    override fun buildUseCaseObservable(params: Unit?): Observable<List<Result>> {
        return searchRepository.getResults()
    }

}