package com.ber.android_hws

import android.os.Bundle
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.databinding.FragmentMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFragment:Fragment(R.layout.fragment_main) {
    private val seriesApi get() = Injector.seriesApi
    lateinit var binding : FragmentMainBinding
    private val _binding get() = binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.apply {
            val layoutManager = LinearLayoutManager(requireContext())
            recycler.layoutManager = layoutManager
            val adapter = SimpleAdapter {
                Toast.makeText(requireContext(), "ITEM -$it", Toast.LENGTH_SHORT).show()
            }
            recycler.adapter = adapter
            recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }

        val list = List<SeriesApi>()
        seriesApi.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                adapter.setData(list)
            }
            .subscribe()
    }
}