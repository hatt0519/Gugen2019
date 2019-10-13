package xyz.moroku0519.gugen2019

import android.app.Application

class GugenApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        gugenApplication = this
    }

    companion object {
        private lateinit var gugenApplication: GugenApplication
        val application: Application
            get() = gugenApplication
    }
}