package xyz.moroku0519.gugen2019

import android.app.Application
import android.content.Context

class GugenApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        gugenApplication = this
    }

    companion object {
        private lateinit var gugenApplication: GugenApplication
        val applicationContext: Context
            get() = gugenApplication.applicationContext
    }
}