package com.achmad.baseandroid.maincompose

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainComposeViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel()
