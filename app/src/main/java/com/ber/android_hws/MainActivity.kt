package com.ber.android_hws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), OnButtonClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.frag_cont,Fragment1()).commit()
    }

    override fun setText(enterText: String) {
        val fragment2 = Fragment2()
        val bundle = Bundle()
        bundle.putString("text",enterText)
        fragment2.arguments = bundle

        supportFragmentManager.beginTransaction()
            .replace(R.id.frag_cont,fragment2)
            .addToBackStack(null)
            .commit()
    }

    override fun showNewActivity(position: Int) {
        val intent = Intent("MyAction")
        intent.putExtra("key", position)
        startActivity(intent)
    }
}


