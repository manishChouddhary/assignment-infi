package com.manish.assignmentlib.ui.about

import android.os.Bundle
import com.manish.assignmentlib.base.BaseFragment

class AboutFragment: BaseFragment() {

    companion object {
        fun newInstance() = AboutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        libViewModel.getFactsUpdate()
    }

}