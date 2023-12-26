package com.sirketismi.uicomponents

import android.app.Application
import com.sirketismi.uicomponents.db.AppDatabase
import com.sirketismi.uicomponents.repository.UserRepository

class MyApplication : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { UserRepository(database.userDao()) }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}