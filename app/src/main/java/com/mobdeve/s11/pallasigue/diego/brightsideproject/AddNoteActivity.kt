package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.annotation.RequiresApi
import java.time.LocalDate

/*This activity is for adding notes to the entry and saving to the database*/
class AddNoteActivity : AppCompatActivity() {

    private lateinit var confirmBtn: Button
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var mood: MoodModel
    private lateinit var noteText: EditText
    private lateinit var note: String


    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)
        noteText = findViewById(R.id.et_note_answer)

        /* gets the intent from the previous activity*/
        val name = intent.getStringExtra("Name")
        val adj = intent.getStringArrayExtra("Adjectives")
        val color = intent.getIntExtra("Color", 0)
        val imageId = intent.getIntExtra("ImageId", 0)


        /* get current date */
        val date = LocalDate.now()

        /* creates a mood model based on the data passed */
        mood = name?.let { adj?.let { it1 -> MoodModel(it,imageId, it1,color) } }!!


        confirmBtn = findViewById(R.id.btn_note_submit)
        confirmBtn.setOnClickListener(View.OnClickListener {
            this.note = noteText.text.toString()
            /* code for adding to the database */
            myDbHelper = MyDbHelper.getInstance(this@AddNoteActivity)!!
            myDbHelper.insertEntry(
                EntryModel(
                    date,
                    mood,
                    this.note
                )
            )
            /* set intent to go back to the homepage */
            val i = Intent(applicationContext, HomePageActivity::class.java)
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); //this code is for finishing the activity
            startActivity(i)
            finish()
        })
    }
}