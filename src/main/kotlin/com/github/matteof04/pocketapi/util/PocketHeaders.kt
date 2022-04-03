/*
 * Copyright (C) 2022 Matteo Franceschini <matteof5730@gmail.com>
 *
 * This file is part of PocketApi.
 * PocketApi is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser General Public License as published by the Free Software Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * PocketApi is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with PocketApi.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.github.matteof04.pocketapi.util

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

object PocketHeaders {
    const val X_ACCEPT = "X-Accept"
    const val X_ERROR = "X-Error"
    const val X_ERROR_CODE = "X-Error-Code"
    const val X_LIMIT_USER_LIMIT = "X-Limit-User-Limit"
    const val X_LIMIT_USER_REMAINING = "X-Limit-User-Remaining"
    const val X_LIMIT_USER_RESET = "X-Limit-User-Reset"
    const val X_LIMIT_KEY_LIMIT = "X-Limit-Key-Limit"
    const val X_LIMIT_KEY_REMAINING = "X-Limit-Key-Remaining"
    const val X_LIMIT_KEY_RESET = "X-Limit-Key-Reset"
}

data class PocketResponseHeaders(
    val userLimit: Int,
    val userRemaining: Int,
    val userReset: Int,
    val keyLimit: Int,
    val keyRemaining: Int,
    val keyReset: Int
){
    fun isValid() = userLimit != -1 && userRemaining != -1 && userReset != -1 && keyLimit != -1 && keyRemaining != -1 && keyReset != -1
}

data class PocketError(
    val errorCode: Int,
    val error: String
){
    fun isValid() = errorCode != -1 && error.isNotBlank()
    override fun toString() = "$errorCode: $error"
}

fun HttpResponse.getPocketHeaders() = PocketResponseHeaders(
    headers[PocketHeaders.X_LIMIT_USER_LIMIT]?.toIntOrNull() ?: -1,
    headers[PocketHeaders.X_LIMIT_USER_REMAINING]?.toIntOrNull() ?: -1,
    headers[PocketHeaders.X_LIMIT_USER_RESET]?.toIntOrNull() ?: -1,
    headers[PocketHeaders.X_LIMIT_KEY_LIMIT]?.toIntOrNull() ?: -1,
    headers[PocketHeaders.X_LIMIT_KEY_REMAINING]?.toIntOrNull() ?: -1,
    headers[PocketHeaders.X_LIMIT_KEY_RESET]?.toIntOrNull() ?: -1
)

fun HttpResponse.getPocketErrorHeaders() = PocketError(
    headers[PocketHeaders.X_ERROR_CODE]?.toIntOrNull() ?: -1,
    headers[PocketHeaders.X_ERROR] ?: ""
)

fun HttpRequestBuilder.setPocketHeaders() {
    contentType(ContentType.Application.Json)
    header(PocketHeaders.X_ACCEPT, ContentType.Application.Json)
}