package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.ber.android_hws.database.Employee
import com.ber.android_hws.databinding.EditFragmentBinding

class FragmentEdit : Fragment(R.layout.edit_fragment) {
    private var _binding: EditFragmentBinding? = null
    private val binding get() = _binding!!
    private val dbInstance get() = Injector.database
    private lateinit var listener: OnBtnClicked

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnBtnClicked
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = EditFragmentBinding.bind(view)
        binding.apply {
            btnSave.setOnClickListener {
                val e = Employee(
                    name = editName.text.toString(),
                    company = editCompany.text.toString(),
                    salary = editSalary.text.toString().toInt()
                )
                dbInstance.employeeDao().insert(e)
                listener.onClicked()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}