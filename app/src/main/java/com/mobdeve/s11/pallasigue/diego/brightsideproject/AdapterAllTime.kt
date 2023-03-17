package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class AdapterAllTime(private val data: ArrayList<EntryModel>): RecyclerView.Adapter<AllTimeViewHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AllTimeViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_weekly_summary, parent, false)

        return AllTimeViewHolder(view)
    }

    override fun onBindViewHolder(holder: AllTimeViewHolder, position: Int) {
        holder.bindData(data[position])
    }

    override fun getItemCount(): Int {
        return data.size
    }
}