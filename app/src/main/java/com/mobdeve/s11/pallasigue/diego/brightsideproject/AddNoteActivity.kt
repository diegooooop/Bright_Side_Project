package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class AddNoteActivity : AppCompatActivity() {

    private lateinit var confirmBtn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        confirmBtn = findViewById(R.id.btn_note_submit)
        confirmBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, HomePageActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i)
        })
    }
}