package com.mobdeve.s11.pallasigue.diego.brightsideproject

// Importing necessary libraries
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Settings
import androidx.core.app.NotificationCompat

/*
* A BroadcastReceiver class that receives an intent to send a notification
* to the user at a specific time.
*/
class MyNotificationReceiver : BroadcastReceiver() {

    // This function is called when the BroadcastReceiver receives an intent.
    override fun onReceive(context: Context?, intent: Intent?) {
        // Get the notification manager service
        val notificationManager = context?.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        /* The intent and pending intent are used to redirect the user to the app
        * when the notification is clicked.
        */
        // Create a new intent to open the HomePageActivity when notification is clicked
        val intent = Intent(context, HomePageActivity::class.java)
        // Create a pending intent to handle the intent in the future.
        val pendingIntent = PendingIntent.getActivity(context, 0, intent, 0)

        /* Setting up the content of the notification */
        // Create a new NotificationCompat.Builder instance to configure the notification's appearance.
        val builder = NotificationCompat.Builder(context, SettingsActivity.CHANNEL_ID)
            .setSmallIcon(R.drawable.logo_round) // Set the small icon for the notification
            .setContentTitle("Hello This is your daily reminder to log your mood!") // Set the title of the notification
            .setContentText("Hi please log your mood today!.") // Set the message of the notification
            .setPriority(NotificationCompat.PRIORITY_DEFAULT) // Set the notification priority
            .setContentIntent(pendingIntent) // Set the pending intent to handle the click on the notification
            .setAutoCancel(true) // Dismiss the notification when it is clicked

        // Show the notification with a unique ID
        notificationManager.notify(SettingsActivity.NOTIFICATION_ID, builder.build())
    }
}
