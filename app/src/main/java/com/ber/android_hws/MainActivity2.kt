package com.ber.android_hws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatTextView

class MainActivity2: AppCompatActivity(R.layout.activity_main2) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val txt = findViewById<AppCompatTextView>(R.id.txt)

        val item = intent.getStringExtra("text")
        txt.text = item
    }
}