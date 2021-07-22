package com.example.resourceconvertersample.login.model

import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val repository: LoginRepository
) {
    private val transactionCoroutine: Mutex = Mutex()

    suspend fun register(mail: String, password: String): Result<Unit> {
        return transactionCoroutine.withLock {
            repository.register(mail, password)
        }
    }

    suspend fun login(mail: String, password: String): Result<Unit> {
        return transactionCoroutine.withLock {
            repository.login(mail, password)
        }
    }
}