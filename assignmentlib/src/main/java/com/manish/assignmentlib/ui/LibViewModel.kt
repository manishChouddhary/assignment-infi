package com.manish.assignmentlib.ui

import com.manish.assignmentlib.base.BaseViewModel
import com.manish.assignmentlib.model.Facts
import com.manish.assignmentlib.network.LibNetworkService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class LibViewModel(
    private val libNetworkService: LibNetworkService
) : BaseViewModel() {
    fun getFactResponseLiveData() = factsResponseLiveData
    fun getFactsTitleTextLiveData() = factsTitleLiveData
    fun getLoadingStateLiveDate() = loadingStateLiveData

    fun getFactsUpdate() {
        loadingStateLiveData.postValue(true)
        val disposable = libNetworkService.getFacts()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe { }
            .subscribe({
                handleSuccessResponse(it)
            }, {
                handleErrorResponse(it)
            })
        compositeDisposable.add(disposable)
    }

    private fun handleSuccessResponse(factsResponse: Facts?) {
        loadingStateLiveData.postValue(false)
        factsResponse?.let {
            factsResponseLiveData.postValue(factsResponse)
            factsListLiveData.postValue(factsResponseLiveData.value?.rows)
            factsTitleLiveData.postValue(factsResponseLiveData.value?.title)
        }
    }

    private fun handleErrorResponse(it: Throwable?) {
        loadingStateLiveData.postValue(false)
    }
}
