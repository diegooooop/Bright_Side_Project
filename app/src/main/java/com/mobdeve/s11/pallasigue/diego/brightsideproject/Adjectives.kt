package com.mobdeve.s11.pallasigue.diego.brightsideproject

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
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
    private lateinit var confirmBtn: Button
    @SuppressLint("RestrictedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_adjectives)
        nameTV = findViewById(R.id.tv_adjective_title)
        confirmBtn = findViewById(R.id.btn_adjective_confirm)

        val name = intent.getStringExtra("Name")
        val i = intent.getStringArrayExtra("Adjectives")
        val color = intent.getIntExtra("Color", 0)

        nameTV.text = name
        nameTV.setTextColor(color)


        this.recyclerView = findViewById(R.id.rv_adjective)
        this.recyclerView.adapter = i?.let { AdapterAdjectives(it, color) }

        this.recyclerView.layoutManager = GridLayoutManager(getActivity(applicationContext), 2)

        confirmBtn.setOnClickListener(View.OnClickListener {
            val i = Intent(applicationContext, AddNoteActivity::class.java)
            startActivity(i)
        })
    }
}