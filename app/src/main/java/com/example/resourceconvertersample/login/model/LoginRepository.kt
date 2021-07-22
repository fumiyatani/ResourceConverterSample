package com.example.resourceconvertersample.login.model

import kotlinx.coroutines.sync.Mutex

interface LoginRepository {
    suspend fun register(mail: String, password: String): Result<Unit>
    suspend fun login(mail: String, password: String): Result<Unit>
}