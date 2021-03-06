package com.manish.assignmentlib

import androidx.fragment.app.Fragment
import com.manish.assignmentlib.dependencyinjection.component.DaggerLibComponent
import com.manish.assignmentlib.dependencyinjection.component.LibComponent
import com.manish.assignmentlib.dependencyinjection.module.LibDiModule
import com.manish.assignmentlib.ui.about.AboutFragment

class LibModule {
    lateinit var libComponent: LibComponent

    lateinit var libCallback: LibCallback

    init {
        initDI()
    }

    private fun initDI() {
        libComponent = DaggerLibComponent.builder()
            .libDiModule(LibDiModule())
            .build()
    }

    fun getEntryFragment(libCallback: LibCallback): Fragment {
        this.libCallback = libCallback
        return AboutFragment.newInstance()
    }

    companion object {
        private var Instance: LibModule = LibModule()
        fun getInstance(): LibModule = Instance
    }
}