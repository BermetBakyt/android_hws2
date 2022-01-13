package com.ber.android_hws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FragmentEdit())
            .addToBackStack(null)
            .commit()

        val btn = findViewById<AppCompatButton>(R.id.btnSave)
        btn.setOnClickListener {

        }
    }

}