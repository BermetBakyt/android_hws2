package com.ber.android_hws

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.appcompat.widget.AppCompatTextView

class MainActivity : AppCompatActivity() {
    private lateinit var input: AppCompatEditText
    private lateinit var text: AppCompatTextView
    private lateinit var btn: AppCompatButton
    private lateinit var launcher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        launcher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == RESULT_OK) {
                text = findViewById(R.id.text)
                text.text = it.data?.getStringExtra("key") ?: "default"
            }
        }

        btn = findViewById(R.id.btn)
        btn.setOnClickListener {
            launcher.launch(Intent(this, MainActivity2::class.java))
        }

    }
}