package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Intent
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)

        switch = findViewById(R.id.switch1)
        time = findViewById(R.id.timeEt)


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
        })
    }
}