package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    private val mood: ArrayList<MoodModel> = DataGenerator.loadData()
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_entry)

        this.recyclerView = findViewById(R.id.rv_adjective)
        this.recyclerView.adapter = AdapterMood(this.mood)

        //this.recyclerView.layoutManager = LinearLayoutManager(this)
        this.recyclerView.layoutManager = GridLayoutManager(ContextUtils.getActivity(applicationContext), 2)

    }
}