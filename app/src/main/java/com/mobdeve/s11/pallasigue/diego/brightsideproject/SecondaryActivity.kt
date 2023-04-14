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
    //Declaring variables
    private lateinit var btn: Button
    private lateinit var userName: EditText
    private val prevStarted = "yes"
    private lateinit var name: String

    companion object {
        const val nameKey = "name_key" //Key for the name stored in the shared preferences
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        //Initialising the variables by finding views
        btn = findViewById(R.id.confirmBtn)
        userName = findViewById(R.id.nameEt)

        //Adding listener to the button
        btn.setOnClickListener(View.OnClickListener {
            if (!userName.text.toString().isNullOrBlank()) {
                name = userName.text.toString()
                val i = Intent(this.applicationContext, HomePageActivity::class.java)
                i.putExtra("name", name)
                startActivity(i)
            } else {
                Toast.makeText(applicationContext, "Please Enter Your Name", Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onResume() {
        super.onResume()

        // Checking if the user has already entered their name before and if yes, skipping this activity and moving to HomePageActivity
        val sp: SharedPreferences = getPreferences(Context.MODE_PRIVATE)

        if (!sp.getBoolean(prevStarted, false)) {
        } else {
            moveToSecondary()
        }
    }

    private fun moveToSecondary() {
        //Use an intent to travel from one activity to another.
        val intent = Intent(this, HomePageActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onPause() {
        super.onPause()

        //Storing the name entered by the user in shared preferences
        name = userName.text.toString()
        val sp: SharedPreferences = getPreferences(Context.MODE_PRIVATE)
        val editor: SharedPreferences.Editor = sp.edit()
        editor.putString(nameKey, userName.text.toString())
        editor.putBoolean(prevStarted, true)
        editor.apply()
    }
}

