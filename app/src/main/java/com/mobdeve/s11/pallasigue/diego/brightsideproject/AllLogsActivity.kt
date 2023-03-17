package com.mobdeve.s11.pallasigue.diego.brightsideproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllLogsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private val allTime: ArrayList<EntryModel> = AlltimeDataGenerator.loadData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_logs)

        this.recyclerView = findViewById(R.id.rv_logs)
        this.recyclerView.adapter = AdapterWeek(this.allTime)
        this.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}