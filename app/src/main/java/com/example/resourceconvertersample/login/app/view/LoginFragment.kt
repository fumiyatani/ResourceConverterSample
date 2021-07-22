package com.example.resourceconvertersample.login.app.view

import com.example.resourceconvertersample.login.app.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment {
    private val viewModel by viewModels<LoginViewModel>()
}