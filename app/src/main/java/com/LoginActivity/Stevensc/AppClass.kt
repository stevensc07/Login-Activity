package com.LoginActivity.Stevensc

import android.app.Application
import com.LoginActivity.Stevensc.util.PreferenceProvider

class AppClass : Application() {
    override fun onCreate() {
        super.onCreate()
        PreferenceProvider.initialize(this)
    }
}