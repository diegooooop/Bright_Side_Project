package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.*
import kotlin.collections.ArrayList
import kotlin.concurrent.schedule

class MainActivity : AppCompatActivity() {

    private val mood: ArrayList<MoodModel> = DataGenerator.loadData()
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_entry)

        this.recyclerView = findViewById(R.id.recyclerView)
        this.recyclerView.adapter = AdapterMood(this.mood)

        this.recyclerView.layoutManager = LinearLayoutManager(this)

    }
}