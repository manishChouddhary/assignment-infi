package com.assignment.manish.assignment.utility

import android.content.res.AssetManager
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

interface AssetLoader {
    fun getConfig(): ApiConfig
}

class AssetLoaderImpl(private val assetsManager: AssetManager) : AssetLoader {
    override fun getConfig(): ApiConfig {
        return Gson().fromJson(BufferedReader(InputStreamReader(assetsManager.open("config.json"))), ApiConfig::class.java)
    }
}