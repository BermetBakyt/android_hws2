package com.ber.android_hws.fragments.add

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.ber.android_hws.R
import com.ber.android_hws.database.Employee
import com.ber.android_hws.database.EmployeeViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mEmployeeViewModel: EmployeeViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mEmployeeViewModel = ViewModelProvider(this).get(EmployeeViewModel::class.java)
        view.btnSave.setOnClickListener {
            insertDataToDatabase()
        }
        return view
    }

    private fun insertDataToDatabase() {
        val name = editTextName.text.toString()
        val company = editTextCompany.text.toString()
        val salary = editTextSalary.text

        if(inputCheck(name, company, salary)) {
            //create User Object
            val employee = Employee(0,name, company, Integer.parseInt(salary.toString()))
            // Add Data to Database
            mEmployeeViewModel.addUser(employee)
            Toast.makeText(requireContext(), "Successfully added!", Toast.LENGTH_SHORT).show()
            // Navigate Back
            findNavController().navigate(R.id.action_listFragment_to_addFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill out all fields", Toast.LENGTH_SHORT).show()
        }
    }
    private fun inputCheck(name: String, company: String, salary: Editable): Boolean {
        return !(TextUtils.isEmpty(name) && TextUtils.isEmpty(company) && salary.isEmpty())
    }
}