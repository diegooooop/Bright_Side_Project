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
        const val nameKey = "name_key"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_secondary)

        btn = findViewById(R.id.confirmBtn)
        userName = findViewById(R.id.nameEt)
        btn.setOnClickListener(View.OnClickListener {
            if(!userName.text.toString().isNullOrBlank()) {
                val i = Intent(this.applicationContext, HomePageActivity::class.java)
                i.putExtra(nameKey, userName.text.toString())
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
        intent.putExtra("name", userName.text)
        startActivity(intent)
    }

    override fun onPause() {
        super.onPause()
        val sp : SharedPreferences = this.getSharedPreferences("HomePageActivity",Context.MODE_PRIVATE)
        val editor : SharedPreferences.Editor = sp.edit()
        editor.putString("namekey", userName.text.toString())
        editor.clear()
        editor.commit()
    }
}
