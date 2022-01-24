package com.ber.android_hws

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.setupActionBarWithNavController
import com.ber.android_hws.fragments.add.AddFragment
import com.ber.android_hws.fragments.list.ListFragment
import com.ber.android_hws.fragments.update.UpdateFragment

class MainActivity : AppCompatActivity(), Navigation {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initFragment()
    }

    private fun initFragment() {
        supportFragmentManager.beginTransaction()
            .add(R.id.fragmentContainerView, ListFragment()).commit()
    }

    override fun onAddClicked() {
        val fragment = AddFragment()
            supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }

    override fun onItemClicked(id: Long) {
        val fragment = UpdateFragment()
        val bundle = Bundle()
        if(id !=null) {
            bundle.putLong("id", id)
        }
        fragment.arguments = bundle
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .addToBackStack(null)
            .commit()
    }

    override fun onClick() {
        val fragment = ListFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainerView, fragment)
            .commit()
    }
}
