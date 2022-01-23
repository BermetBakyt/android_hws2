package com.ber.android_hws.fragments.update

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import android.widget.Toolbar
import com.ber.android_hws.Injector
import com.ber.android_hws.MainActivity
import com.ber.android_hws.Navigation
import com.ber.android_hws.R
import com.ber.android_hws.database.Employee
import com.ber.android_hws.databinding.FragmentUpdateBinding
import kotlinx.android.synthetic.main.fragment_add.*

class UpdateFragment : Fragment(R.layout.fragment_update) {
    private var _binding: FragmentUpdateBinding ?= null
    private val binding get() = _binding!!

    private lateinit var listener: Navigation
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUpdateBinding.bind(view)

        binding.apply {
            // show prev data
            val id = arguments?.getLong(MainActivity.ID_KEY) ?: 1L
            val prevInput = dbInstance.employeeDao().getById(id)

            var name = prevInput.name
            var company = prevInput.company
            var salary = prevInput.salary.toString()

            btnUpdate.setOnClickListener {
                if (editTextName.text.isNullOrEmpty()) {
                    name = editTextName.text.toString()
                }
                if (editTextCompany.text.isNullOrEmpty()) {
                    company = editTextCompany.text.toString()
                }
                if (editTextSalary.text.isNullOrEmpty()) {
                    salary = editTextSalary.text.toString()
                }

                val employee = Employee(id, name, company, salary.toInt())
                dbInstance.employeeDao().update(employee)

                Toast.makeText(context, "Inputs updated", Toast.LENGTH_SHORT).show()
            }
        }
        val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
        toolbar.inflateMenu(R.menu.menu)

        toolbar.setNavigationIcon(R.drawable.delete_btn)
        toolbar.setNavigationOnClickListener {
            deleteEmployee()
        }
    }

    private fun deleteEmployee() {
        binding.apply {
            // show prev data
            val id = arguments?.getLong(MainActivity.ID_KEY) ?: 1L
            val prevInput = dbInstance.employeeDao().getById(id)

            var name = prevInput.name
            var company = prevInput.company
            var salary = prevInput.salary.toString()

            val employee = Employee(id, name, company, salary.toInt())
                dbInstance.employeeDao().update(employee)

                Toast.makeText(context, "Inputs updated", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}





