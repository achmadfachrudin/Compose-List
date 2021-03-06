package com.achmad.baseandroid.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.achmad.baseandroid.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    companion object {
        fun createIntent(
            context: Context,
        ): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configureBinding()

        binding.textTitle.text = viewModel.coba
    }

    private fun configureBinding() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}
