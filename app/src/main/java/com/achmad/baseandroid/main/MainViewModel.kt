package com.achmad.baseandroid.main

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import com.achmad.baseandroid.cache.PrefConstant.USERNAME
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val sharedPreferences: SharedPreferences,
) : ViewModel() {

    val username = sharedPreferences.getString(USERNAME, "admin")
}
