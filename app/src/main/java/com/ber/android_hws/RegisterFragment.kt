package com.ber.android_hws

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import androidx.fragment.app.Fragment

class RegisterFragment: Fragment(R.layout.fragment_register) {
    private lateinit var listener: Navigator
    private var passwordIsNotEmpty = false
    private var loginIsNotEmpty = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as Navigator
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val newLogin = view.findViewById<AppCompatEditText>(R.id.new_login)
        val newPassword = view.findViewById<AppCompatEditText>(R.id.new_password)
        val newButton = view.findViewById<AppCompatButton>(R.id.new_btn)

        newLogin.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {}
            override fun beforeTextChanged(p0: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    loginIsNotEmpty = false
                } else {
                    if (passwordIsNotEmpty) {
                        newButton.isEnabled = true
                    }
                    loginIsNotEmpty = true
                }
            }
        })

        newPassword.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(
                p0: CharSequence?,
                start: Int,
                before: Int,
                count: Int
            ) {
            }

            override fun onTextChanged(p0: CharSequence?, start: Int, before: Int, count: Int) {
                if (p0.isNullOrEmpty()) {
                    passwordIsNotEmpty = false
                } else {
                    if (loginIsNotEmpty) {
                        newButton.isEnabled = true
                    }
                    passwordIsNotEmpty = true
                }
            }
        })
        newButton.setOnClickListener {
            listener.changePrefs(newLogin.text.toString(), newPassword.text.toString())
        }
    }
}



