package com.manish.assignmentlib.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.manish.assignmentlib.error.LibException
import com.manish.assignmentlib.model.Fact
import com.manish.assignmentlib.model.Facts
import io.reactivex.disposables.CompositeDisposable

open class BaseViewModel : ViewModel() {
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable()
    protected val factsResponseLiveData = MutableLiveData<Facts>()
    protected val factsTitleLiveData = MutableLiveData<String>()
    protected val factsListLiveData = MutableLiveData<List<Fact>>()
    protected val loadingStateLiveData = MutableLiveData<Boolean>()
    protected val errorStateLiveData = MutableLiveData<LibException>()
}