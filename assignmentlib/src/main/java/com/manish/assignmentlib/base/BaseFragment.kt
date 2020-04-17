package com.manish.assignmentlib.base

import android.os.Bundle
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
                LibViewModel(libCallback, libNetworkService)
            }).get(LibViewModel::class.java)
    }
}