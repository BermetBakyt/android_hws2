package com.ber.android_hws

import android.os.Bundle
import androidx.fragment.app.Fragment
import com.ber.android_hws.database.Employee
import com.ber.android_hws.databinding.ActivityMainBinding

class FragmentEdit : Fragment(R.layout.edit_fragment) {
    private lateinit var binding: ActivityMainBinding
    private val dbInstance get() = Injector.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.apply {
            btnSave.setOnClickListener {
                val e = Employee(
                    name = editName.text.toString()
                    company = editCompany.text.toString()
                    salary = editSalary.text.toString()
                )
            }
        }
    }
}