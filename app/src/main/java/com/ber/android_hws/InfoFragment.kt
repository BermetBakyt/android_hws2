package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ber.android_hws.databinding.FragmentInfoBinding
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class InfoFragment: Fragment(R.layout.fragment_info) {

    private val api get() = Injector.seriesApi
    private var _binding: FragmentInfoBinding ?= null
    private val binding get() = _binding!!
    private lateinit var listener: Navigation

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentInfoBinding.bind(view)
        val id = arguments?.getLong("id") ?: 1L

        binding.apply {
            api.getCharacterById(id)
                .subscribeOn(Schedulers.io())
                .map { it.first() }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSuccess{
                    episodeTitle.text = "Title: ${it.title}"
                    episodeSeason.text = "Season: ${it.season}"
                    episode.text = "Episode: ${it.episode}"
                    episodeCharacters.text = "Characters: ${it.characters}"
                    episodeDate.text = "Date: ${it.air_date}"
                    episodesSeries.text = "Series: ${it.series}"
                }
                .observeOn(AndroidSchedulers.mainThread())
                .doOnError {
                    Toast.makeText(requireContext(),"Error", Toast.LENGTH_SHORT).show()
                }
                .subscribe()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}