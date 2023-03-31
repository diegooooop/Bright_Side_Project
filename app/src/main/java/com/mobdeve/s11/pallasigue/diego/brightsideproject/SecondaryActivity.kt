package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class SecondaryActivity : AppCompatActivity() {

    private lateinit var btn: Button
    private lateinit var userName: EditText
    private val prevStarted = "yes"
    private lateinit var name: String
    override fun onResume() {
        super.onResume()

        val sharedPreferences = getSharedPreferences(getString(R.string.app_name), Context.MODE_PRIVATE)

        if (!sharedPreferences.getBoolean(prevStarted, false)) {
            val editor = sharedPreferences.edit()
            editor.putBoolean(prevStarted, true)
            editor.apply()
        }
        else {
            moveToSecondary()
        }
    }

    companion object {
        var nameKey = "name_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        btn = findViewById(R.id.confirmBtn)
        userName = findViewById(R.id.nameEt)
        btn.setOnClickListener(View.OnClickListener {
            if(!userName.text.toString().isNullOrBlank()) {
                name = userName.text.toString()
                val i = Intent(this.applicationContext, HomePageActivity::class.java)
                startActivity(i)
                finish()
            }
            else{
                Toast.makeText(applicationContext,"Please Enter Your Name", Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun moveToSecondary() {
        // use an intent to travel from one activity to another.
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPause() {
        super.onPause()
        name = userName.text.toString()
        val sp : SharedPreferences = this.getSharedPreferences(getString(R.string.app_name),Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()
        editor.putString(SecondaryActivity.nameKey, name)
        editor.apply()
    }
}
