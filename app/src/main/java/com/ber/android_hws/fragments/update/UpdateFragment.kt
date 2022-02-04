package com.ber.android_hws.fragments.update

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import com.ber.android_hws.Injector
import com.ber.android_hws.Navigation
import com.ber.android_hws.R
import com.ber.android_hws.database.Employee
import com.ber.android_hws.databinding.FragmentUpdateBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_add.*

class UpdateFragment : Fragment(R.layout.fragment_update) {
    private var _binding: FragmentUpdateBinding ?= null
    private val binding get() = _binding!!

    private lateinit var listener: Navigation
    private val dbInstance get() = Injector.database

    private var empId: Long = -1L

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentUpdateBinding.bind(view)

        binding.apply {
            // show prev data
            val id = arguments?.getLong("id") ?: 1L
            if (id < 0) {
                Toast.makeText(activity, "Такого id нет", Toast.LENGTH_SHORT).show()
            }
                btnUpdate.setOnClickListener {
                    val e = Employee(
                        id = id,
                        name = editTextCompany.text.toString(),
                        company = editTextCompany.text.toString(),
                        salary = editTextSalary.text.toString().toInt()
                    )

                    dbInstance.employeeDao().update(e)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .doOnComplete {
                            Toast.makeText(context, "Inputs updated", Toast.LENGTH_SHORT).show()
                        }
                        .doOnError {
                            Toast.makeText(context, "Try again", Toast.LENGTH_SHORT).show()
                        }
                        .subscribe()
                }
            val toolbar = view.findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
            toolbar.inflateMenu(R.menu.menu)
            toolbar.setOnMenuItemClickListener {
                when (it.itemId) {
                    R.id.menu_delete -> { deleteEmployee(id) }
                }
                true
            }
        }
    }
    private fun deleteEmployee(id: Long) {
        binding.apply {
            // show prev data
            dbInstance.employeeDao().getById(id)
                .subscribeOn(Schedulers.io())
                .flatMapCompletable {
                    dbInstance.employeeDao().delete(it)
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnComplete {
                    Toast.makeText(context, "Inputs deleted", Toast.LENGTH_SHORT).show()
                }
                .doOnError{
                    Toast.makeText(context, "Something went wrong. Try again", Toast.LENGTH_SHORT).show()
                }
                .subscribe()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}








