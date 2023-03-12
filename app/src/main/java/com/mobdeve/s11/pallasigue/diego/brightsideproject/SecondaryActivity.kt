package com.mobdeve.s11.pallasigue.diego.brightsideproject

import androidx.appcompat.app.AppCompatActivity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

private lateinit var btn: Button
private lateinit var userName: EditText

class SecondaryActivity : AppCompatActivity() {

        private val prevStarted = "yes"

        override fun onResume() {
            super.onResume()
            val sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)
            if (!sharedPreferences.getBoolean(prevStarted, false)) {
                val editor = sharedPreferences.edit()
                editor.putBoolean(prevStarted, true)
                editor.apply()
            } else {
                moveToSecondary()
            }
        }

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_secondary)

            btn = findViewById(R.id.confirmBtn)
            userName = findViewById(R.id.nameEt)
            btn.setOnClickListener(View.OnClickListener {
                if(!userName.text.toString().isNullOrBlank()) {
                    val i = Intent(this.applicationContext, MainActivity::class.java)
                    startActivity(i)
                }
            })


        }

        private fun moveToSecondary() {
            // use an intent to travel from one activity to another.
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
