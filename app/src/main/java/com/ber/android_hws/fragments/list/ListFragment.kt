package com.ber.android_hws.fragments.list

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.Injector
import com.ber.android_hws.Navigation
import com.ber.android_hws.R
import com.ber.android_hws.databinding.FragmentListBinding

class ListFragment : Fragment(R.layout.fragment_list) {
    private var _binding: FragmentListBinding ?= null
    private val binding get() = _binding!!

    private lateinit var listener: Navigation
    private val dbInstance get() = Injector.database

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListBinding.bind(view)

        binding.apply {
            //Adapter
            val adapter = ListAdapter {
                listener.onItemClicked(it)
            }
            recycler.adapter = adapter
            recycler.layoutManager = LinearLayoutManager(requireContext())
            recycler.addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))

            val list = dbInstance.employeeDao().getAll()
            adapter.setData(list)

            //add button
            floatingActionButton.setOnClickListener {
                listener.onAddClicked()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}