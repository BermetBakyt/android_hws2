package com.ber.android_hws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    override fun onItemClicked(id: Long) {
        val infoFragment = InfoFragment()
        val bundle = Bundle()
        bundle.putLong("id", id)
        infoFragment.arguments = bundle

        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, InfoFragment())
            .addToBackStack(null)
            .commit()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_container, MainFragment())
            .commit()
    }

}
