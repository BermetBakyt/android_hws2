package com.ber.android_hws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var txt: AppCompatTextView
    private lateinit var input: AppCompatEditText
    private lateinit var btn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txt = findViewById(R.id.text)
        input = findViewById(R.id.edit)
        btn = findViewById(R.id.btn)

        btn.setOnClickListener {
            val text = input.text.toString().trim()
            val listOfWords = text.split("\\s+".toRegex())
            var maxAs = 0
            var word = ""

            listOfWords.forEach {
                if (it.contains('a')) {
                    val numOfAs = it.count{c -> c == 'a'}
                    if (maxAs < numOfAs)
                    {
                        maxAs = numOfAs
                        word = it
                    }
                }
            }

            txt.text = "number of maximum 'a's = $maxAs\n in the word: $word"
        }
    }


}