package com.example.resourceconvertersample.login.model

sealed class Result<out R>

class Success<out T>(result: T) : Result<T>()
class Failure(reason: Throwable) : Result<Nothing>()

class EmptyMailError(message: String) : Throwable(message)
class EmptyPasswordError(message: String) : Throwable(message)
class SameMailError(message: String) : Throwable(message)
class SameUserError(message: String) : Throwable(message)