package com.assignment.manish.assignment

import android.app.Application
import com.assignment.manish.assignment.utility.AssetLoader
import com.assignment.manish.assignment.utility.AssetLoaderImpl

class AppApplication : Application() {
    companion object {
        lateinit var assetLoader: AssetLoader
    }
    override fun onCreate() {
        super.onCreate()
        assetLoader = AssetLoaderImpl(this.resources.assets)
    }
}