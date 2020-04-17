package com.manish.assignmentlib.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manish.assignmentlib.model.Fact
import com.manish.assignmentlib.model.Facts
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    val factsTitleLiveData = MutableLiveData<String>()
    val factsListLiveData = MutableLiveData<List<Fact>>()
    val loadingStateLiveData = MutableLiveData<Boolean>()
}