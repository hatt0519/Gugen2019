package xyz.moroku0519.gugen2019

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager

class GugenApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        gugenApplication = this
        getSystemService(NotificationManager::class.java).run {
            createNotificationChannel(
                NotificationChannel("10", "girl", NotificationManager.IMPORTANCE_HIGH).apply {
                    description = "girl"
                    enableVibration(true)
                    enableLights(true)
                }
            )
        }
    }

    companion object {
        private lateinit var gugenApplication: GugenApplication
        val application: Application
            get() = gugenApplication
    }
}