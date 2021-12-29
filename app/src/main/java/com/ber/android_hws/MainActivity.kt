package com.ber.android_hws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val adapter = SimpleAdapter{
            Toast.makeText(this, "this is the item - $it", Toast.LENGTH_SHORT).show()
        }

        val recycler = binding.recycler
        recycler.adapter = adapter
        recycler.layoutManager = GridLayoutManager(this, 2)
        recycler.addItemDecoration(DividerItemDecoration(this, RecyclerView.VERTICAL))

        val list = mutableListOf<String>()
        for (i in 1..30) {
            list.add("ITEM - $i")
        }

        adapter.setData(list)
    }
}