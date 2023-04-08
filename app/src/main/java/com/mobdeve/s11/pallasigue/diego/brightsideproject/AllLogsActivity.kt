package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.content.ContentValues.TAG
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.time.Month
import java.time.Year

class AllLogsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    @RequiresApi(Build.VERSION_CODES.O)
    private lateinit var monthspin: Spinner
    private lateinit var yearspin: Spinner
    private lateinit var myDbHelper: MyDbHelper
    private lateinit var allTime: ArrayList<EntryModel>
    private lateinit var sortSpin: Spinner
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
        if (yearspin != null){
            val adapter2 = ArrayAdapter(this, android.R.layout.simple_spinner_item, years)
            yearspin.adapter = adapter2
        }

        val sort = resources.getStringArray(R.array.Sort)
        sortSpin = findViewById(R.id.spr_sort)
        if (sortSpin != null){
            val adapter3 = ArrayAdapter(this, android.R.layout.simple_spinner_item, sort)
            sortSpin.adapter = adapter3
        }

        this.recyclerView = findViewById(R.id.rv_logs)
        this.recyclerView.adapter = AdapterAllTime(this.allTime)
        this.recyclerView.layoutManager = LinearLayoutManager(this)

        yearspin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedMonth = monthspin.selectedItem as? String
                val selectedYearValue = parent.getItemAtPosition(position).toString()
                val yearValue = selectedYearValue.toInt()
                Log.d(TAG, "selected value is: $yearValue")

                if(selectedMonth == "All" && yearValue != null)
                {
                    val filterDates = allTime.filter { myObject -> myObject.date.year == yearValue}
                        recyclerView.adapter = AdapterAllTime(filterDates as ArrayList<EntryModel>)
                }
                else if(selectedMonth != "All" && yearValue != null)
                {
                    val month = selectedMonth?.let { Month.valueOf(it.toUpperCase()) }
                    val filteredDates = allTime.filter { myObject -> myObject.date.year == yearValue && month?.let {
                        myObject.date.withMonth(it.value) } == myObject.date}
                    recyclerView.adapter = AdapterAllTime(filteredDates as ArrayList<EntryModel>)
                }
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
            }
        }

        monthspin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedMonthValue = parent.getItemAtPosition(position).toString()
                val year = yearspin.selectedItem as? String
                val yearValue = year?.toInt()
                Log.d(TAG, "selected value is: $selectedMonthValue")
                Log.d(TAG, "selected value is: $yearValue")


                if(selectedMonthValue == "All" && yearValue != null)
                {
                    val filterDates = allTime.filter { myObject -> myObject.date.year == yearValue}
                    recyclerView.adapter = AdapterAllTime(filterDates as ArrayList<EntryModel>)
                }
                else if(selectedMonthValue != "All" && yearValue != null)
                {
                    val month = Month.valueOf(selectedMonthValue.toUpperCase())
                    val filteredObjects = allTime.filter {myObject -> myObject.date.year == yearValue && month?.let {
                        myObject.date.withMonth(it.value) } == myObject.date}
                    recyclerView.adapter = AdapterAllTime(filteredObjects as ArrayList<EntryModel>)
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }

        fun sortObjectsList(allData: ArrayList<EntryModel>, option: String): MutableList<EntryModel> {
            val sortedList = allData.toMutableList()
            when (option) {
                "Ascending" -> sortedList.sortWith { obj1, obj2 ->
                    obj1.date.compareTo(obj2.date)
                }
                "Descending" -> sortedList.sortWith { obj1, obj2 ->
                    obj2.date.compareTo(obj1.date)
                }
            }
            return sortedList
        }
// Set up the Spinner's OnItemSelectedListener to handle sorting option selection
        sortSpin.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View?, position: Int, id: Long) {
                val selectedItem = parent.getItemAtPosition(position) as String
                val year = yearspin.selectedItem as? String
                val yearValue = year?.toInt()
                val selectedMonth = monthspin.selectedItem as? String

                if(selectedMonth == "All" && yearValue != null)
                {
                    val filterDates = allTime.filter { myObject -> myObject.date.year == yearValue}
                    val sortedList = sortObjectsList(filterDates as ArrayList<EntryModel>, selectedItem)
                    recyclerView.adapter = AdapterAllTime(sortedList as ArrayList<EntryModel>)
                }
                else if(selectedMonth != "All" && yearValue != null)
                {
                    val month = selectedMonth?.let { Month.valueOf(it.toUpperCase()) }
                    val filteredObjects = allTime.filter {myObject -> myObject.date.year == yearValue && month?.let {
                        myObject.date.withMonth(it.value) } == myObject.date}
                    val sortedList = sortObjectsList(filteredObjects as ArrayList<EntryModel>, selectedItem)
                    recyclerView.adapter = AdapterAllTime(sortedList as ArrayList<EntryModel>)
                }


            }

            override fun onNothingSelected(parent: AdapterView<*>) {}
        }
    }
}