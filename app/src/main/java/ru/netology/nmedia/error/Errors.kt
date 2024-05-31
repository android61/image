package ru.netology.nmedia.error

import java.io.IOException
import java.sql.SQLException

sealed class AppError(val code: Int, val info: String) : RuntimeException(info) {
    companion object {
        fun from(e: Throwable) = when(e) {
            is IOException -> NetworkException
            is SQLException -> DbException
            is ApiException -> e
            else -> UnknownException
        }
    }
}

class ApiException(code : Int, message: String) : AppError(code, message)

object DbException: AppError(-1, "error_db")
object NetworkException: AppError(-1, "no_network")
object UnknownException: AppError(-1, "unknown")