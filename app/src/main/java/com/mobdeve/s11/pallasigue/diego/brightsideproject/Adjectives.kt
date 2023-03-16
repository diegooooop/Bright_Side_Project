package com.mobdeve.s11.pallasigue.diego.brightsideproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class Adjectives : AppCompatActivity()
{
    private lateinit var nameTV: TextView
    private lateinit var recyclerView: RecyclerView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjectives)
        nameTV = findViewById(R.id.tv_adjective_title)
        val name = intent.getStringExtra("Name")
        val i = intent.getStringArrayExtra("Adjectives")

        nameTV.text = name


        this.recyclerView = findViewById(R.id.rv_adjective)
        this.recyclerView.adapter = i?.let { AdapterAdjectives(it) }
        this.recyclerView.layoutManager = LinearLayoutManager(this)
    }
}