package com.example.resourceconvertersample.login.app.viewmodel

import com.example.resourceconvertersample.login.model.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) {

}