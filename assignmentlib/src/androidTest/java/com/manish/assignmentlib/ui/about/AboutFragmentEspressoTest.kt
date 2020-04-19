package com.manish.assignmentlib.ui.about

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.manish.assignmentlib.MockInterceptor
import com.manish.assignmentlib.MockProvider
import com.manish.assignmentlib.R
import com.manish.assignmentlib.TestActivityBase
import com.manish.assignmentlib.extentions.RecyclerViewMatcher
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

@RunWith(AndroidJUnit4::class)
class AboutFragmentEspressoTest : TestActivityBase() {
    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
    }

    @Test
    fun test_facts_list_on_success() {
        `when`(callback.getRetrofitClient()).thenReturn(MockProvider.getMockRetrofitClient(MockInterceptor.MockRequest.FACTS_UPDATE_SUCCESS))
        setUpAboutFragment()
        onView(withText(MockProvider.page_title)).check(matches(isDisplayed()))
        onView(RecyclerViewMatcher(R.id.rvFactsList).atPositionOnView(0, R.id.tvTitle))
            .check(matches(isDisplayed()))
            .check(matches(withText(MockProvider.title)))

        onView(RecyclerViewMatcher(R.id.rvFactsList).atPositionOnView(0,R.id.tvDescription))
            .check(matches(isDisplayed()))
            .check(matches(withText(MockProvider.description)))

        onView(RecyclerViewMatcher(R.id.rvFactsList).atPositionOnView(0,R.id.ivFactImage))
            .check(matches(isDisplayed()))
            .check(matches(withContentDescription(activityRule.activity.getString(R.string.fact_image_description))))
    }

    @Test
    fun test_refresh_facts_list() {
        `when`(callback.getRetrofitClient()).thenReturn(MockProvider.getMockRetrofitClient(MockInterceptor.MockRequest.FACTS_UPDATE_SUCCESS))
        setUpAboutFragment()
        onView(withId(R.id.srlFactsList)).perform(swipeDown())
        onView(RecyclerViewMatcher(R.id.rvFactsList).atPositionOnView(0, R.id.tvTitle))
            .check(matches(isDisplayed()))
            .check(matches(withText(MockProvider.title)))
    }

    @Test
    fun test_facts_list_on_error() {
        `when`(callback.getRetrofitClient()).thenReturn(MockProvider.getMockRetrofitClient(MockInterceptor.MockRequest.FACTS_UPDATE_ERROR))
        setUpAboutFragment()
        onView(withText(activityRule.activity.getString(R.string.error_message))).check(matches(isDisplayed()))
    }
}