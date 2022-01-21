package com.ber.android_hws.fragments.update

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ber.android_hws.Navigation
import com.ber.android_hws.R
import kotlinx.android.synthetic.main.fragment_update.view.*

class UpdateFragment : Fragment(R.layout.fragment_update) {

    private lateinit var listener: Navigation
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigation
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}