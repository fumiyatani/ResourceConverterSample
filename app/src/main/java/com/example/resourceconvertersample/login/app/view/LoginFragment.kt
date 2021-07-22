package com.example.resourceconvertersample.login.app.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.resourceconvertersample.databinding.FragmentLoginBinding
import com.example.resourceconvertersample.login.app.viewmodel.LoginViewModel
import com.example.resourceconvertersample.login.app.viewmodel.LoginViewModel.Message
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private val viewModel by viewModels<LoginViewModel>()

    private lateinit var binding: FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentLoginBinding.inflate(layoutInflater).also {
        binding = it
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewmodel = viewModel
    }.also {
        viewModel.messageFlow
            .onEach { onMessage(it) }
            .launchIn(lifecycleScope)
    }.root

    private fun onMessage(message: Message) {
        when (message) {
            is Message.Succeeded -> notifySucceeded()
            is Message.Failed -> notifyFailed()
        }
    }

    private fun notifySucceeded() {
        Toast.makeText(requireContext(), "ログイン成功", Toast.LENGTH_SHORT).show()
    }

    private fun notifyFailed() {
        Toast.makeText(requireContext(), "ログイン失敗", Toast.LENGTH_SHORT).show()
    }
}