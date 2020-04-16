package com.manish.assignmentlib.dependencyinjection.component

import com.manish.assignmentlib.dependencyinjection.module.LibDiModule
import dagger.Component

@Component(modules = [LibDiModule::class])
interface LibComponent {
}