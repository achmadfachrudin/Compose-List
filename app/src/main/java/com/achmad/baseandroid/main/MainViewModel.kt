package com.achmad.baseandroid.main

import android.content.SharedPreferences
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {

    val coba = sharedPreferences.getString("firstStoredString", "0")
}
