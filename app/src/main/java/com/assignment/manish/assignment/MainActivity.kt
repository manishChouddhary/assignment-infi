package com.assignment.manish.assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.manish.assignmentlib.extentions.replace
import com.manish.assignmentlib.LibModule

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val callback = LibCallbackImplementation()
        val fragment = LibModule.getInstance().getEntryFragment(callback)
        replace(fragment, R.id.container, false, fragment::class.java.canonicalName)
    }
}