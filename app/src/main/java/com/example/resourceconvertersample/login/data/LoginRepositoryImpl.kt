package com.example.resourceconvertersample.login.data

import com.example.resourceconvertersample.login.model.*

class LoginRepositoryImpl : LoginRepository {
    private val users: MutableMap<String, String> = mutableMapOf()

    override suspend fun register(mail: String, password: String): Result<Unit> {
        return runCatching {
            requireMailAndPassword(mail, password)
            requireSameMail(mail)

            users[mail] = password

            Success(Unit)
        }.getOrElse { Failure(it) }
    }

    override suspend fun login(mail: String, password: String): Result<Unit> {
        return runCatching {
            requireMailAndPassword(mail, password)
            requireNotSameUser(mail, password)

            Success(Unit)
        }.getOrElse { Failure(it) }
    }

    private fun requireMailAndPassword(mail: String, password: String) {
        if (mail.isBlank()) throw EmptyMailError("メールが空です")
        if (password.isBlank()) throw EmptyPasswordError("パスワードが空です")
    }

    private fun requireSameMail(mail: String) {
        if (!users[mail].isNullOrBlank()) throw SameMailError("メールが同じです")
    }

    private fun requireNotSameUser(mail: String, password: String) {
        if (!users.keys.contains(mail)) throw SameUserError("メールアドレスかパスワードが間違ってます。")
        if (users[mail] != password) throw SameUserError("メールアドレスかパスワードが間違ってます。")
    }
}