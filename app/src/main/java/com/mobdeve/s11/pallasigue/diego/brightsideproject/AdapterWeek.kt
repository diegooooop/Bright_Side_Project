package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
/* adapter for setting up the weekly layout activities */
class AdapterWeek(private val data: ArrayList<EntryModel>): RecyclerView.Adapter<WeekViewHolder>() {

    /* standard onCreateViewHolder function */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeekViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_weekly_entry, parent, false)

        return WeekViewHolder(view)
    }
    /* standard onBindViewHolder */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: WeekViewHolder, position: Int) {
        holder.bindData(data[position])
    }
    /* standard function for returning item size */
    override fun getItemCount(): Int {
        return data.size
    }
}