package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TimePickerDialog
import android.content.ContentValues.TAG
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit


class SettingsActivity : AppCompatActivity() {

    companion object {
        val NOTIFICATION_ID = 1
        val CHANNEL_ID = "my_channel_id"
    }
    private lateinit var switch: Switch
    private lateinit var time: EditText
    private lateinit var confbtn: Button
    private lateinit var nameEt: EditText
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        switch = findViewById(R.id.switch1)
        time = findViewById(R.id.timeEt)
        nameEt = findViewById(R.id.name_ET)
        /* code for setting the switch for enabling or disabling setting time for notification */
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
        /* This code pops up a time picker dialog upon clicking the time edittext box*/
       time.setOnClickListener(View.OnClickListener {
           var picker = TimePickerDialog(this@SettingsActivity,
               { tp, sHour, sMinute -> time.setText("$sHour:$sMinute ") },  0, 0, false
           )
           picker.show()
       })

        confbtn = findViewById(R.id.confirmBtn)
        confbtn.setOnClickListener(View.OnClickListener {
           if(switch.isChecked) {
               val timeString = time.text.toString()
               Log.d(TAG, "time is $timeString")
                /* this code splits the hour and minutes from the set time*/
               val parts = timeString.trim().split(":")

               val hour = parts[0].toInt()
               val minute = parts[1].toInt()
               this.scheduleNotification(hour, minute)
               Log.d(TAG, "hours is $hour, minutes is $minute")
           }
            val i = Intent(applicationContext, HomePageActivity::class.java)
            startActivity(i)
            finish()
        })
    }
    override fun onStart() {
        super.onStart()
        val sp : SharedPreferences = getSharedPreferences("SecondaryActivity", Context.MODE_PRIVATE)
        val nameValue = sp.getString(SecondaryActivity.nameKey, "test")
        /* code for intiializing the name and setting the saved hours and minutes of the time */
        if(nameValue == "")
        {
            val s : SharedPreferences = getSharedPreferences("SettingsActivity", Context.MODE_PRIVATE)
            val name = s.getString("name", "test")
            val timeSet = s.getLong("time", 0)


            val hours = TimeUnit.MILLISECONDS.toHours(timeSet)
            val minutes = TimeUnit.MILLISECONDS.toMinutes(timeSet - TimeUnit.HOURS.toMillis(hours))
            nameEt.setText(name.toString())
            time.setText("$hours:$minutes")
        }
        else {
            nameEt.setText(nameValue.toString())
            time.setText(0)
        }
        val check = sp.getBoolean("checked", false)
        switch.isChecked = check
        time.isEnabled = check
        time.isClickable = check
        time.isActivated = check
    }

    /* This function saves the input using sharedpreference on the name textbox and time textbox*/
    override fun onPause() {
        super.onPause()
        val timeString = time.text.toString() // get the text from the EditText
        val dateFormat = SimpleDateFormat("hh:mm", Locale.getDefault())
        val date = dateFormat.parse(timeString)
        val timeInMillis = date?.time ?: 0 // get time in milliseconds
        //Writing
        val sp : SharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()
        editor.putString("name",nameEt.text.toString())
        editor.putLong("time",timeInMillis)
        editor.putBoolean("checked", switch.isChecked)
        editor.apply()
    }

    /* This function sets the notification time based on the hour and minutes set in the edittexts*/
    @SuppressLint("ServiceCast")
    fun scheduleNotification(hour: Int, minute: Int) {
        val calendar = Calendar.getInstance()
        calendar.set(Calendar.HOUR_OF_DAY, hour) // Hour of the day (24-hour clock)
        calendar.set(Calendar.MINUTE, minute) // Minute of the hour
        calendar.set(Calendar.SECOND, 0) // Second of the minute
        calendar.timeInMillis


        val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

//        notificationManager.notify(NOTIFICATION_ID, builder.build())
        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.timeInMillis,  AlarmManager.INTERVAL_DAY, PendingIntent.getBroadcast(applicationContext, 0, Intent(applicationContext, MyNotificationReceiver::class.java), PendingIntent.FLAG_UPDATE_CURRENT))
    }
}