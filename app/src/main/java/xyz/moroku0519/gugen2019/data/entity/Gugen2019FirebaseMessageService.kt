package xyz.moroku0519.gugen2019.data.entity

import android.app.Notification
import android.app.PendingIntent
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import xyz.moroku0519.gugen2019.GugenApplication
import xyz.moroku0519.gugen2019.R
import xyz.moroku0519.gugen2019.ui.MainActivity

class Gugen2019FirebaseMessageService : FirebaseMessagingService() {
    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        val notification = NotificationCompat.Builder(this, "10").apply {
            setAutoCancel(true)
            setContentTitle(getString(R.string.app_name))
            setContentText("お水が欲しいよ〜")
            setSmallIcon(R.drawable.ic_launcher_foreground)
            setPriority(NotificationCompat.PRIORITY_HIGH)
            setContentIntent(PendingIntent.getActivity(GugenApplication.application.applicationContext, 0, Intent(this@Gugen2019FirebaseMessageService, MainActivity::class.java), PendingIntent.FLAG_UPDATE_CURRENT))
            setDefaults(Notification.DEFAULT_ALL)
        }.build()
        NotificationManagerCompat.from(this).notify(notification.hashCode(), notification)
    }
}