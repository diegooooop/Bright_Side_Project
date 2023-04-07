package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CompoundButton
import android.widget.EditText
import android.widget.Switch
import androidx.appcompat.app.AppCompatActivity


class SettingsActivity : AppCompatActivity() {

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
}