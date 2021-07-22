package com.example.resourceconvertersample.login.app.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.resourceconvertersample.login.model.Failure
import com.example.resourceconvertersample.login.model.LoginUseCase
import com.example.resourceconvertersample.login.model.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    // Two-Way Binding
    val userMail: MutableLiveData<String> = MutableLiveData()
    val userPassword: MutableLiveData<String> = MutableLiveData()

    // イベント通知
    private val _messageFlow = MutableSharedFlow<Message>()
    val messageFlow: SharedFlow<Message>
        get() = _messageFlow

    fun onClickLogin() {
        val mail = userMail.value ?: return
        val password = userPassword.value ?: return

        viewModelScope.launch {
            when (val result = loginUseCase.login(mail, password)) {
                is Success -> {
                    _messageFlow.emit(Message.Succeeded)
                }
                is Failure -> {
                    _messageFlow.emit(Message.Failed(result))
                }
            }
        }
    }

    fun onClickRegister() {
        val mail = userMail.value ?: return
        val password = userPassword.value ?: return

        viewModelScope.launch {
            when (val result = loginUseCase.register(mail, password)) {
                is Success -> {
                    _messageFlow.emit(Message.Succeeded)
                }
                is Failure -> {
                    _messageFlow.emit(Message.Failed(result))
                }
            }
        }
    }

    sealed class Message {
        object Succeeded : Message()
        class Failed(reason: Failure) : Message()
    }
}