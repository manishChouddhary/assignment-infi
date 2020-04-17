package com.manish.assignmentlib.ui

import com.manish.assignmentlib.LibCallback
import com.manish.assignmentlib.base.BaseViewModel
import com.manish.assignmentlib.model.Facts
import com.manish.assignmentlib.network.LibNetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LibViewModel(private val callback: LibCallback,
                   private val libNetworkService: LibNetworkService) : BaseViewModel() {
    fun getFactListLiveData() = factsListLiveData
    fun getFactsUpdate() {
        loadingStateLiveData.postValue(true)
        val disposable = libNetworkService.getFacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {  }
            .subscribe({
                handleSuccessResponse(it)
            },{
                handleErrorResponse(it)
            })
        compositeDisposable.add(disposable)
    }

    private fun handleSuccessResponse(factsResponse: Facts?) {
        factsResponse?.let {
            factsTitleLiveData.postValue(it.title)
            factsListLiveData.postValue(it.rows)
        }
    }

    private fun handleErrorResponse(it: Throwable?) {
        loadingStateLiveData.postValue(false)
    }
}
