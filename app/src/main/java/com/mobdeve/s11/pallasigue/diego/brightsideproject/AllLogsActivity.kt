package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class AllLogsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    @RequiresApi(Build.VERSION_CODES.O)
    private val allTime: ArrayList<EntryModel> = AlltimeDataGenerator.loadData()
    private lateinit var monthspin: Spinner
    private lateinit var yearspin: Spinner
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_logs)

        val months = resources.getStringArray(R.array.Months)
        monthspin = findViewById(R.id.spr_month)
        if (monthspin != null){
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, months)
            monthspin.adapter = adapter
        }

        val years = resources.getStringArray(R.array.Years)
        yearspin = findViewById(R.id.spr_year)
        if (monthspin != null){
            val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
            yearspin.adapter = adapter2
        }


        this.recyclerView = findViewById(R.id.rv_logs)
        this.recyclerView.adapter = AdapterWeek(this.allTime)
        this.recyclerView.layoutManager = LinearLayoutManager(this)



    }
}