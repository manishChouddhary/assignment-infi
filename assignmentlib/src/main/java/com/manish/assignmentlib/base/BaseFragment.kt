package com.manish.assignmentlib.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.manish.assignmentlib.LibCallback
import com.manish.assignmentlib.LibModule
import com.manish.assignmentlib.network.LibNetworkService
import com.manish.assignmentlib.ui.LibViewModel
import com.manish.assignmentlib.utility.ViewModelProviderFactory
import javax.inject.Inject

open class BaseFragment: Fragment() {
    @Inject
    lateinit var libCallback: LibCallback

    @Inject
    lateinit var libNetworkService: LibNetworkService

    lateinit var libViewModel: LibViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LibModule.getInstance().libComponent.inject(this)
        libViewModel = ViewModelProvider(
            requireActivity(),
            ViewModelProviderFactory(LibViewModel::class) {
                LibViewModel(libNetworkService)
            }).get(LibViewModel::class.java)
    }

    fun setUpToolbar(title: String?) {
        (requireActivity() as AppCompatActivity).apply{
            supportActionBar?.apply {
                setDisplayHomeAsUpEnabled(true)
                setTitle(title)
            }
        }
    }
}