package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView

class AdapterAllTime(private val data: ArrayList<EntryModel>): RecyclerView.Adapter<AllTimeViewHolder>()  {
    /* standard onCreateViewHolder */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_alltime_entry, parent, false)

        return AllTimeViewHolder(view)
    }
    /* standard onBindViewHolder */
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: AllTimeViewHolder, position: Int) {
        holder.bindData(data[position])
    }
    /* standard function for returning item size */
    override fun getItemCount(): Int {
        return data.size
    }
}