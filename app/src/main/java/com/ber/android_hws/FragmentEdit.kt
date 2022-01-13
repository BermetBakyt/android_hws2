package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ber.android_hws.database.Employee
import com.ber.android_hws.databinding.ActivityMainBinding
import com.ber.android_hws.databinding.EditFragmentBinding

class FragmentEdit : Fragment() {
    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            btnSave.setOnClickListener {
                val e = Employee(
                    name = editName.text.toString(),
                    company = editCompany.text.toString(),
                    salary = editSalary.text.toString().toInt()
                )
                dbInstance.employeeDao().insert(e)
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EditFragmentBinding.bind(view)
        binding.btnSave.setOnClickListener {

        }
    }
}