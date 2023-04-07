package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class AdapterAdjectives(private val data: ArrayList<AdjectiveCheckBoxModel> , private val color: Int): RecyclerView.Adapter<AdjectiveViewHolder>() {

    private lateinit var chosen: ArrayList<String>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdjectiveViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_layout_adjectives, parent, false)

        return AdjectiveViewHolder(view)
    }

    override fun onBindViewHolder(holder: AdjectiveViewHolder, position: Int){
        holder.bindData(data[position].name, color)
        holder.adjective.setOnClickListener(View.OnClickListener {
            if(holder.adjective.isChecked)
            {
                holder.adjective.isChecked = true
                data[position].checked = holder.adjective.isChecked
            }
            else if(!holder.adjective.isChecked)
            {
                holder.adjective.isChecked = false
                data[position].checked = holder.adjective.isChecked
            }
        })
    }

    override fun getItemCount(): Int {
        return data.size
    }
}