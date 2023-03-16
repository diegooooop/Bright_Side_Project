package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
class HomePageActivity : AppCompatActivity() {

    //generate affirmation array

    private lateinit var homeName: TextView
    private lateinit var affirmationPic: ImageView
    private lateinit var logBtn: Button
    private lateinit var weekBtn: Button
    private lateinit var historyBtn: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //generate affirmation array
        val affirmation = intArrayOf(R.drawable.affirmation1,R.drawable.affirmation2,R.drawable.affirmation3,
            R.drawable.affirmation4,R.drawable.affirmation5)

        //generate random number
        val num = Random.nextInt(0,5)

        //set the greetings to the username given
        homeName = findViewById(R.id.tv_home_name)
        val username = intent.getStringExtra("name")
        homeName.text = username

        //load affirmation pic
        affirmationPic = findViewById(R.id.affirmationIv)
   //     affirmationPic.setImageResource(affirmation[num])
        affirmationPic.setImageResource(R.drawable.test)

        logBtn = findViewById(R.id.moodBtn)
        logBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, MainActivity::class.java)
            startActivity(i)
        })

        weekBtn = findViewById(R.id.weekBtn)
        weekBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, WeeklySummaryActivity::class.java)
            startActivity(i)
        })

        logBtn = findViewById(R.id.logsBtn)

    }
}