package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class AuthorizeFragment : Fragment(R.layout.authorize_fragment) {
    private lateinit var listener: Navigator
    private var passwordIsNotEmpty = false
    private var loginIsNotEmpty = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val login = view.findViewById<AppCompatEditText>(R.id.login)
        val password = view.findViewById<AppCompatEditText>(R.id.password)
        val button = view.findViewById<AppCompatButton>(R.id.auto_btn)

        login.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) { }
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    loginIsNotEmpty = false
                } else {
                    if (passwordIsNotEmpty) {
                        button.isEnabled = true
                    }
                    loginIsNotEmpty = true
                }
            }
        })
        password.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(p0: Editable?) { }
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) { }
            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    passwordIsNotEmpty = true
                } else {
                    if (loginIsNotEmpty) {
                        button.isEnabled = true
                    }
                    passwordIsNotEmpty = true
                }
            }
        })
        button.setOnClickListener {
                listener.checkPrefs(login.text.toString(), password.text.toString())
            }
        }
    }
