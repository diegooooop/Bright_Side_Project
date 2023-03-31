package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class AdapterAdjectives(private val data: Array<String> , private val color: Int): RecyclerView.Adapter<AdjectiveViewHolder>() {

    lateinit var chosen: ArrayList<String>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdjectiveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_adjectives, parent, false)

        return AdjectiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdjectiveViewHolder, position: Int){
        holder.bindData(data[position], color)
    }

    override fun getItemCount(): Int {
        return data.size
    }
}