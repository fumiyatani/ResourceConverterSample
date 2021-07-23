package com.example.resourceconvertersample.login.model

sealed class Result<out R>

class Success<out T>(val result: T) : Result<T>()
class Failure(val reason: FailureReason) : Result<Nothing>()

sealed class FailureReason(override val message: String) : Throwable(message)
class EmptyMailError(message: String) : FailureReason(message)
class EmptyPasswordError(message: String) : FailureReason(message)
class SameMailError(message: String) : FailureReason(message)
class SameUserError(message: String) : FailureReason(message)