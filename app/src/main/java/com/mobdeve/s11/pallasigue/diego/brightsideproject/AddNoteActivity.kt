package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.annotation.RequiresApi
import java.time.LocalDate

class AddNoteActivity : AppCompatActivity() {

    private lateinit var confirmBtn: Button
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var mood: MoodModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val name = intent.getStringExtra("Name")
        val adj = intent.getStringArrayExtra("Adjectives")
        val color = intent.getIntExtra("Color", 0)
        var imageId = intent.getIntExtra("ImageId", 0)

        //dummy data
        val note = "I am happy"
        val date = LocalDate.now()

        mood = name?.let { adj?.let { it1 -> MoodModel(it,imageId, it1,color) } }!!


        confirmBtn = findViewById(R.id.btn_note_submit)
        confirmBtn.setOnClickListener(View.OnClickListener {

            myDbHelper = MyDbHelper.getInstance(this@AddNoteActivity)!!
            myDbHelper.insertEntry(
                EntryModel(
                    date,
                    mood,
                    note
                )
            )

            val i = Intent(applicationContext, HomePageActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(i)
            finish()
        })
    }
}