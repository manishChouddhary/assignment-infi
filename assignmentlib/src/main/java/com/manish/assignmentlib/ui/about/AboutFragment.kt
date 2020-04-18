package com.manish.assignmentlib.ui.about

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.manish.assignmentlib.R
import com.manish.assignmentlib.base.BaseFragment
import com.manish.assignmentlib.extentions.gone
import com.manish.assignmentlib.extentions.visible
import com.manish.assignmentlib.model.Fact
import kotlinx.android.synthetic.main.fragment_facts_list.*

class AboutFragment: BaseFragment() {

    private lateinit var factsListObserver: Observer<List<Fact>>
    private lateinit var titleObserver: Observer<String>
    private lateinit var loadingObserver: Observer<Boolean>

    companion object {
        fun newInstance() = AboutFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        libViewModel.getFactsUpdate()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_facts_list, container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeLoadingState()
        observeTitle()
        observeFactResponse()
    }

    private fun observeFactResponse() {
        libViewModel.getFactResponseLiveData().observe(viewLifecycleOwner,  Observer{ it ->
            it?.let { facts ->
                rvFactsList?.let{ view ->
                    view.visible()
                    view.adapter = FactsListAdaptor().apply { factsList = facts.rows.filter { it.title.isNullOrEmpty().not() }}
                }
                setUpToolbar(facts.title)
            }
        })
    }

    private fun observeTitle() {
        libViewModel.getFactsTitleTextLiveData().observe(viewLifecycleOwner, Observer{
            it?.apply { setUpToolbar(it) }
        })
    }

    private fun observeLoadingState() {
        libViewModel.getLoadingStateLiveDate().observe(viewLifecycleOwner, Observer{
            when(it){
                true -> { pvLoading?.visible() }
                false -> { pvLoading?.gone() }
            }
        })
    }
}