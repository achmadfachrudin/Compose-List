package com.achmad.baseandroid.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.achmad.baseandroid.databinding.ActivityLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBinding()

        configureViews()
        observeLogin()
    }

    private fun configureBinding() {
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    private fun configureViews() {
        with(binding) {

            buttonLogin.setOnClickListener {
                viewModel.doLogin(
                    editTextUsername.text.toString().trim(),
                    editTextPassword.text.toString().trim()
                )
            }
        }
    }

    private fun observeLogin() {
        lifecycleScope.launchWhenCreated {
            viewModel.loginFlow.collect {
                when (it) {
                    "success" -> goToMain()
                    else -> showError(it)
                }
            }
        }
    }

    private fun goToMain() {
        startActivity(
            MainActivity.createIntent(this)
        )
        finish()
    }

    private fun showError(errorMessage: String) {
        if (errorMessage.isNotEmpty()) {
            Toast.makeText(this, errorMessage, Toast.LENGTH_SHORT).show()
        }
    }
}
