package com.adoyo.stagelighting.presentation.auth.presentation

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.adoyo.stagelighting.presentation.auth.domain.model.User
import com.adoyo.stagelighting.presentation.auth.domain.use_cases.AuthUseCase
import com.adoyo.stagelighting.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authUseCase: AuthUseCase): ViewModel(){
    private val _signInResult = MutableStateFlow<Resource<User>>(Resource.Loading())
    val signInResult: StateFlow<Resource<User>> = _signInResult

    private val _signUpResult = MutableStateFlow<Resource<User>>(Resource.Loading())
    val signUpResult: StateFlow<Resource<User>> = _signUpResult

    private val _email = mutableStateOf("")
    val email = _email

    private val _password = mutableStateOf("")
    val password = _password

    fun onEmailChange(email: String) {
        _email.value = email
    }

    fun onPasswordChange(password: String) {
        _password.value = password
    }

    fun signIn(email: String,password: String) = viewModelScope.launch {
        _signUpResult.value = Resource.Loading()
        val result = authUseCase.signIn(email,password)
        _signUpResult.value = result
    }

    fun signUp(email: String, password: String) = viewModelScope.launch {
        _signUpResult.value = Resource.Loading()
        val result = authUseCase.signUp(email,password)
        _signUpResult.value = result
    }



}