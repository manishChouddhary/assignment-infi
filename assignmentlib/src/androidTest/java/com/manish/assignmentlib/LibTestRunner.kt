package com.manish.assignmentlib

import android.os.Bundle
import androidx.test.runner.AndroidJUnitRunner

class LibTestRunner: AndroidJUnitRunner() {
    override fun onCreate(arguments: Bundle?) {
        super.onCreate(arguments)
    }

    override fun finish(resultCode: Int, results: Bundle?) {
        super.finish(resultCode, results)
    }
}