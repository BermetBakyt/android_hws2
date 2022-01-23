package com.ber.android_hws.fragments.add

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.ber.android_hws.Injector
import com.ber.android_hws.Navigation
import com.ber.android_hws.R
import com.ber.android_hws.database.Employee
import kotlinx.android.synthetic.main.fragment_add.*

class AddFragment : Fragment(R.layout.fragment_add) {

    private lateinit var listener: Navigation
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnSave.setOnClickListener {
            if (editTextName.text.isNullOrEmpty() || editTextCompany.text.isNullOrEmpty() || editTextSalary.text.isNullOrEmpty()) {
                Toast.makeText(context, "Заполните все поля", Toast.LENGTH_SHORT).show()
            } else {
                val e = Employee(
                    name = editTextName.text.toString(),
                    company = editTextCompany.text.toString(),
                    salary = editTextSalary.text.toString().toInt()
                )
                dbInstance.employeeDao().insert(e)

                Toast.makeText(context, "Запись добавлена", Toast.LENGTH_LONG).show()
            listener.showListFragment()
        }
    }
}
}