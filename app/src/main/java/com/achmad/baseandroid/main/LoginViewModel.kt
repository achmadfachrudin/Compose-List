package com.achmad.baseandroid.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.achmad.baseandroid.service.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    private val _loginFlow = MutableStateFlow("")
    var loginFlow: StateFlow<String> = _loginFlow

    fun doLogin(username: String, password: String) {
        viewModelScope.launch {
            postRepository.fetchLogin(username = username, password = password).collectLatest {
                _loginFlow.value = it
            }
        }
    }
}
