package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SnapHelper
import java.time.ZoneId
import java.util.*
import kotlin.collections.ArrayList

class WeeklySummaryActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var week: ArrayList<EntryModel>

    @RequiresApi(Build.VERSION_CODES.O)
   // private val week: ArrayList<EntryModel> = WeeklyDataGenerator.loadData()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weekly_summary)

        myDbHelper = MyDbHelper.getInstance(this@WeeklySummaryActivity)!!
        this.week = myDbHelper.getAllEntriesDefault()

        // Get the start and end dates of the current week
        val calendar = Calendar.getInstance()
        calendar.firstDayOfWeek = Calendar.MONDAY
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.MONDAY)
        val startDate = calendar.time.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()
        calendar.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY)
        val endDate = calendar.time.toInstant().atZone(ZoneId.systemDefault()).toLocalDate()

// Filter the list of objects based on their LocalDate property
        val filteredList = week.filter { obj -> obj.date in startDate..endDate }

        this.recyclerView = findViewById(R.id.rv_days)
        this.recyclerView.adapter = AdapterWeek(filteredList as ArrayList<EntryModel>)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.HORIZONTAL
        this.recyclerView.layoutManager = linearLayoutManager

        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
    }
}