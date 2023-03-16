package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random
class HomePageActivity : AppCompatActivity() {

    //generate affirmation array

    private lateinit var greetings: TextView
    private lateinit var affirmationPic: ImageView

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        //generate affirmation array
        val affirmation = intArrayOf(R.drawable.affirmation1,R.drawable.affirmation2,R.drawable.affirmation3,
            R.drawable.affirmation4,R.drawable.affirmation5,R.drawable.affirmation6,R.drawable.affirmation7,
            R.drawable.affirmation8,R.drawable.affirmation9,R.drawable.affirmation10)

        //generate random number
        val num = Random.nextInt(0,10)

        //set the greetings to the username given
        greetings = findViewById(R.id.greetingTv)
        val username = intent.getStringExtra("name")
        greetings.text = "Good Morning + $username"

        //load affirmation pic
        affirmationPic = findViewById(R.id.affirmationIv)
        affirmationPic.setImageResource(affirmation[num])

    }
}