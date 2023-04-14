package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

/* The activity for choosing the activities the user will do*/
class HomePageActivity : AppCompatActivity() {

    //generate affirmation array

    private lateinit var homeName: TextView
    private lateinit var affirmationPic: ImageView
    private lateinit var moodBtn: Button
    private lateinit var weekBtn: Button
    private lateinit var logsBtn: Button
    private lateinit var settings: ImageButton

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //generate affirmation array
        val affirmation = intArrayOf(R.drawable.affirmation1,R.drawable.affirmation2,R.drawable.affirmation3)

        //generate random number
        val num = Random.nextInt(0,3)

        //set the greetings to the username given
        homeName = findViewById(R.id.tv_home_name)



        //load affirmation pic
        affirmationPic = findViewById(R.id.affirmationIv)
        affirmationPic.setImageResource(affirmation[num])
        //affirmationPic.setImageResource(R.drawable.test)

        moodBtn = findViewById(R.id.moodBtn)
        moodBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        })

        weekBtn = findViewById(R.id.weekBtn)
        weekBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, WeeklySummaryActivity::class.java)
            startActivity(i)
        })

        logsBtn = findViewById(R.id.logsBtn)
        logsBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, AllLogsActivity::class.java)
            startActivity(i)
        })

        settings = findViewById(R.id.settingsBtn)
        settings.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, SettingsActivity::class.java)
            startActivity(i)
        })
    }

    override fun onStart() {
        super.onStart()
        val sp : SharedPreferences = getSharedPreferences("SettingsActivity", Context.MODE_PRIVATE)
        val nameValue = sp.getString("name", "test")
        if(nameValue == "test")
        {
            val username = intent.getStringExtra("name")
            homeName.text = username
        }
        else{
            homeName.text = nameValue
        }

    }
}