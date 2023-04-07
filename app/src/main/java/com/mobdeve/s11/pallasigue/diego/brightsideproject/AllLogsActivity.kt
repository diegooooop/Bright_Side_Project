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
    private lateinit var monthspin: Spinner
    private lateinit var yearspin: Spinner
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var allTime: ArrayList<EntryModel>
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_all_logs)

        myDbHelper = MyDbHelper.getInstance(this@AllLogsActivity)!!
        this.allTime = myDbHelper.getAllEntriesDefault()

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
        this.recyclerView.adapter = AdapterAllTime(this.allTime)
        this.recyclerView.layoutManager = LinearLayoutManager(this)



    }
}