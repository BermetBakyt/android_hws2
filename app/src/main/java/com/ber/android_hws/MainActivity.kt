package com.ber.android_hws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), OnBtnClicked {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, FragmentEdit())
            .commit()
    }

    override fun onClicked() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, FragmentSave())
            .addToBackStack(null)
            .commit()
    }
}
