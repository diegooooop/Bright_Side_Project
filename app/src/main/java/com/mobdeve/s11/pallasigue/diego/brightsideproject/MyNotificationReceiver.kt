package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.app.NotificationCompat

class MyNotificationReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val intent = Intent(context, HomePageActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        val builder = NotificationCompat.Builder(context, SettingsActivity.CHANNEL_ID)
            .setSmallIcon(R.drawable.logo_round)
            .setContentTitle("Hello This is your daily reminder to log your mood!")
            .setContentText("Hi please log your mood today!.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)

        notificationManager.notify(SettingsActivity.NOTIFICATION_ID, builder.build())
    }
}