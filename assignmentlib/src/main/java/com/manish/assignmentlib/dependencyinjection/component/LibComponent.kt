package com.manish.assignmentlib.dependencyinjection.component

import com.manish.assignmentlib.base.BaseFragment
import com.manish.assignmentlib.dependencyinjection.module.LibDiModule
import dagger.Component

@Component(modules = [LibDiModule::class])
interface LibComponent {
    fun inject(baseFragment: BaseFragment)
}