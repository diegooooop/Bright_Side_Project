package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.content.ContentValues.TAG
import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity

/*This adapter is for populating the adjectives for the adjectives activity*/
class Adjectives : AppCompatActivity()
{
    private lateinit var nameTV: TextView
    private lateinit var recyclerView: RecyclerView
    private lateinit var confirmBtn: Button
    private lateinit var adapter: AdapterAdjectives


    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjectives)
//        nameTV = findViewById(R.id.tv_adjective_title)
        confirmBtn = findViewById(R.id.btn_adjective_confirm)

        /* gets the content of the chosen mood from intent */
        val name = intent.getStringExtra("Name")
        val adj = intent.getStringArrayExtra("Adjectives")
        val color = intent.getIntExtra("Color", 0)
        var imageId = intent.getIntExtra("ImageId", 0)

        /* initializes an arraylist for storing the adjective checkbox model*/
        var chosenAdj = ArrayList<AdjectiveCheckBoxModel>()

        /* this function just adds the array of adj to the chosenadj arraylist */
        if (adj != null) {
            for(item in adj){
                val adjName = item.toString()
                chosenAdj.add(AdjectiveCheckBoxModel(adjName, false))
            }
        }
        Log.d(TAG, "name is : ${chosenAdj.get(1)}")

        this.adapter = AdapterAdjectives(chosenAdj, color)


        this.recyclerView = findViewById(R.id.rv_adjective)
        this.recyclerView.layoutManager = GridLayoutManager(getActivity(applicationContext), 2)
        this.recyclerView.adapter = this.adapter



        confirmBtn.setOnClickListener(View.OnClickListener {

            var chosen = ArrayList<String>()
            /*this cose is for getting the checked adjecctives by accessing the checked boolean value*/
            for(item in chosenAdj){
                if(item.checked)
                {
                    chosen.add(item.name)
                }
                else{}
            }
            /* transform the arraylist to array of string */
            var chosenArr: Array<String> = chosen.toTypedArray()

            val i = Intent(applicationContext, AddNoteActivity::class.java)
            i.putExtra("Name", name)
            i.putExtra("ImageId", imageId)
            i.putExtra("Adjectives", chosenArr)
            i.putExtra("Color", color)
            startActivity(i)
        })
    }
}