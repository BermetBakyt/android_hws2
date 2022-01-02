package com.ber.android_hws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var input: AppCompatEditText
    private lateinit var text: AppCompatTextView
    private lateinit var btn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input = findViewById(R.id.edit)
        text = findViewById(R.id.text)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {

            text.text = input.text.toString().split("\\P{L}+".toRegex())
                .filter { it.count { it == 'o'} == 1 }
                .size
                .toString()
        }
    }
}