package com.manish.assignmentlib

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.manish.assignmentlib.network.LibNetworkService
import com.manish.assignmentlib.ui.LibViewModel
import io.reactivex.Single
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class LibViewModelTest {
    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    private lateinit var libNetworkService: LibNetworkService

    private lateinit var viewModel: LibViewModel

    @Before
    fun setup() {
        RxUnitTestTool.asyncToSync()
        viewModel = LibViewModel(libNetworkService)
    }

    @Test
    fun getFactsUpdateTest() {
        `when`(libNetworkService.getFacts()).thenReturn(Single.just(MockDataProvider.getMockFactsResponse()))
        viewModel.getFactsUpdate()
        val list = viewModel.getFactResponseLiveData().value?.rows
        list?.get(0)?.apply {
            assert(this.title == MockDataProvider.title)
            assert(this.imageHref == MockDataProvider.imageHref)
            assert(this.description == MockDataProvider.description)
        }
    }

    @Test
    fun getFactsUpdateErrorTest() {
        `when`(libNetworkService.getFacts()).thenReturn(Single.error(Throwable()))
        viewModel.getFactsUpdate()
        assert(viewModel.getLoadingStateLiveDate().value == false)
    }

    @Test
    fun getFactsTitleTextLiveDataTest()
    {
        `when`(libNetworkService.getFacts()).thenReturn(Single.just(MockDataProvider.getMockFactsResponse()))
        viewModel.getFactsUpdate()
        assert(viewModel.getFactsTitleTextLiveData().value == MockDataProvider.page_title)
    }

    @Test
    fun getLoadingStateLiveDateTest()
    {
        `when`(libNetworkService.getFacts()).thenReturn(Single.just(MockDataProvider.getMockFactsResponse()))
        viewModel.getFactsUpdate()
        assert(viewModel.getLoadingStateLiveDate().value == false)
    }
}