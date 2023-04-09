package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat
import java.util.*


class SettingsActivity : AppCompatActivity() {

    companion object {
        val NOTIFICATION_ID = 1
        val CHANNEL_ID = "my_channel_id"
    }
    private lateinit var switch: Switch
    private lateinit var time: EditText
    private lateinit var confbtn: Button
    private lateinit var nameEt: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        switch = findViewById(R.id.switch1)
        time = findViewById(R.id.timeEt)
        nameEt = findViewById(R.id.name_ET)

        this.scheduleNotification()

        switch.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            // do something, the isChecked will be
            // true if the switch is in the On position
            if(isChecked){
                time.isEnabled = true
                time.isClickable = true
                time.isActivated = true
            }
            else{
                time.isEnabled = false
                time.isClickable = false
                time.isActivated = false
            }

        })
        confbtn = findViewById(R.id.confirmBtn)
        confbtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, HomePageActivity::class.java)
            startActivity(i)
            finish()
        })
    }
    override fun onStart() {
        super.onStart()
        val sp : SharedPreferences = getSharedPreferences("SecondaryActivity", Context.MODE_PRIVATE)
        val nameValue = sp.getString(SecondaryActivity.nameKey, "test")
        if(nameValue == "")
        {
            val s : SharedPreferences = getSharedPreferences("SettingsActivity", Context.MODE_PRIVATE)
            val name = s.getString("name", "test")
            nameEt.setText(name.toString())
        }
        else {
            nameEt.setText(nameValue.toString())
        }
    }

    override fun onPause() {
        super.onPause()
        //Writing
        val sp : SharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()
        editor.putString("name", nameEt.text.toString())
        editor.apply()
    }
    @SuppressLint("ServiceCast")
    fun scheduleNotification() {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, 9) // Hour of the day (24-hour clock)
        calendar.set(Calendar.MINUTE, 0) // Minute of the hour
        calendar.set(Calendar.SECOND, 0) // Second of the minute

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            // Create the notification channel
            val name = "My Notification Channel"
            val descriptionText = "This is my notification channel"
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val channel = NotificationChannel(CHANNEL_ID, name, importance).apply {
                description = descriptionText
            }

            // Register the notification channel with the system
            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            //notificationManager.createNotificationChannel(channel)
        }

        val builder = NotificationCompat.Builder(applicationContext, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("My Notification")
            .setContentText("This is my notification.")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(NOTIFICATION_ID, builder.build())
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setExact(AlarmManager.RTC_WAKEUP, calendar.timeInMillis, PendingIntent.getBroadcast(applicationContext, 0, Intent(applicationContext, MyNotificationReceiver::class.java), PendingIntent.FLAG_UPDATE_CURRENT))
    }
}