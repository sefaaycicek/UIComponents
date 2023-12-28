package com.sirketismi.uicomponents

import android.app.Application
import com.sirketismi.uicomponents.db.AppDatabase
import com.sirketismi.uicomponents.repository.UserRepository
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}