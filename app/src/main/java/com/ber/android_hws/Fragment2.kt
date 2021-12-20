package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment

class Fragment2 : Fragment(R.layout.fragment_2){

    private lateinit var listener : OnButtonClicked
    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as OnButtonClicked
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val txt2 = view.findViewById<AppCompatTextView>(R.id.txt2)
        val entText = arguments?.getString("text")
        txt2.text = entText.toString()
    }

}