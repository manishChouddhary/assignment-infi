package com.manish.assignmentlib

import android.app.Instrumentation
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.rule.ActivityTestRule
import org.mockito.Mock

open class TestActivityBase {

    @JvmField
    val activityRule = ActivityTestRule(TestActivity::class.java,false,false)

    @Mock
    lateinit var callback: LibCallback

    private lateinit var instrumentation : Instrumentation

    fun setUpAboutFragment() {
        instrumentation = InstrumentationRegistry.getInstrumentation()
        activityRule.launchActivity(null)
        val aboutFragment = LibModule.getInstance().getEntryFragment(callback)
        val fragmentManager = activityRule.activity.supportFragmentManager
        fragmentManager.beginTransaction()
            .replace(R.id.fragment_container_view_tag,aboutFragment)
            .commit()
        instrumentation.waitForIdleSync()
    }
}