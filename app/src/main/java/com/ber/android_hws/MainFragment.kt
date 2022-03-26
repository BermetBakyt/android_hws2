package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ber.android_hws.database.CharacterApi
import com.ber.android_hws.databinding.FragmentMainBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MainFragment:Fragment(R.layout.fragment_main) {
    private val seriesApi get() = Injector.seriesApi
    private val binding get() = _binding!!
    private var _binding : FragmentMainBinding? = null
    private lateinit var adapter: Adapter
    private lateinit var listener: Navigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentMainBinding.bind(view)

        binding.apply {
            val layoutManager = LinearLayoutManager(requireContext())
            recycler.layoutManager = layoutManager
            adapter = Adapter {
                listener.onItemClicked(it)
            }
            recycler.adapter = adapter
            recycler.addItemDecoration(DividerItemDecoration(requireContext(), RecyclerView.VERTICAL))
        }

        seriesApi.getRepositories()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnNext {
                adapter.setData(it)
            }
            .doOnError {
                Log.e("Ber","error $it")
            }
            .subscribe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}