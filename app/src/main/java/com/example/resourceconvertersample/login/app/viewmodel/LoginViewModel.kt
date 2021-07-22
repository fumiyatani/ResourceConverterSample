package com.example.resourceconvertersample.login.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.resourceconvertersample.login.model.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    val userMail: MutableLiveData<String> = MutableLiveData()

    val userPassword: MutableLiveData<String> = MutableLiveData()

}