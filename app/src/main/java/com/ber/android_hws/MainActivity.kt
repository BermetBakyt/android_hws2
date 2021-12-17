package com.ber.android_hws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycler)
        val layoutManager = LinearLayoutManager(this)
        val adapter = SimpleAdapter {
            Toast.makeText(this, "Item - $it", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            startActivity(intent)
        }
        recycler.layoutManager = layoutManager
        recycler.adapter = adapter
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 0..20) {
            list.add("ITEM -$i")
        }
        adapter.setData(list)
    }
}

