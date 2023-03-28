package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WeeklySummaryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    @RequiresApi(Build.VERSION_CODES.O)
    private val week: ArrayList<EntryModel> = WeeklyDataGenerator.loadData()
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly_summary)

        this.recyclerView = findViewById(R.id.rv_days)
        this.recyclerView.adapter = AdapterWeek(this.week)
        this.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}