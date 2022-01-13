package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ber.android_hws.databinding.SaveFragmentBinding

class FragmentSave : Fragment(R.layout.save_fragment) {
    private var _binding: SaveFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = SaveFragmentBinding.bind(view)

        binding.apply {
            val e = dbInstance.employeeDao().getById(1L)
            txtName.text = e.name
            txtCompany.text = e.company
            txtSalary.text = e.salary.toString()
        }
    }
}