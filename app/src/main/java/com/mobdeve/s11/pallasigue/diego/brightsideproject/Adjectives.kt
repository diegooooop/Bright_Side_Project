package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.internal.ContextUtils.getActivity


class Adjectives : AppCompatActivity()
{
    private lateinit var nameTV: TextView
    private lateinit var recyclerView: RecyclerView
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjectives)
        nameTV = findViewById(R.id.tv_adjective_title)
        val name = intent.getStringExtra("Name")
        val i = intent.getStringArrayExtra("Adjectives")

        nameTV.text = name


        this.recyclerView = findViewById(R.id.rv_adjective)
        this.recyclerView.adapter = i?.let { AdapterAdjectives(it) }

        this.recyclerView.layoutManager = GridLayoutManager(getActivity(applicationContext), 2)
//            LinearLayoutManager(this)
//        topicListView.setLayoutManager(GridLayoutManager(getActivity(), 3))
    }
}