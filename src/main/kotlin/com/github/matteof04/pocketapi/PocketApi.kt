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

package com.github.matteof04.pocketapi

import com.github.matteof04.pocketapi.entities.auth.AccessTokenRequest
import com.github.matteof04.pocketapi.entities.auth.AccessTokenResponse
import com.github.matteof04.pocketapi.entities.auth.RequestTokenRequest
import com.github.matteof04.pocketapi.entities.auth.RequestTokenResponse
import com.github.matteof04.pocketapi.exceptions.PocketException
import com.github.matteof04.pocketapi.util.PocketEndpoints
import com.github.matteof04.pocketapi.util.getPocketErrorHeaders
import com.github.matteof04.pocketapi.util.setPocketHeaders
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.engine.cio.*
import io.ktor.client.features.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import io.ktor.client.features.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.ExperimentalSerializationApi

open class PocketApi(protected val consumerKey: String) {
    protected val client = HttpClient(CIO){
        install(JsonFeature){
            serializer = KotlinxSerializer(kotlinx.serialization.json.Json {
                ignoreUnknownKeys = true
                coerceInputValues = true
            })
        }
        install(Logging){
            logger = Logger.DEFAULT
            level = LogLevel.ALL
        }
        HttpResponseValidator {
            validateResponse {
                val pocketError = it.getPocketErrorHeaders()
                if(pocketError.isValid()) {
                    throw PocketException(it, pocketError)
                }
            }
        }
    }
    fun getRequestToken(redirectUri: String) = runBlocking {
        client.post<HttpResponse>(PocketEndpoints.REQUEST_TOKEN){
            setPocketHeaders()
            body = RequestTokenRequest(consumerKey, redirectUri)
        }.receive<RequestTokenResponse>()
    }
    fun getAuthorizationUrl(requestToken: String, redirectUri: String) = "https://getpocket.com/auth/authorize?request_token=$requestToken&redirect_uri=$redirectUri"
    fun getAuthorizationUrl(redirectUri: String) = getAuthorizationUrl(getRequestToken(redirectUri).requestToken, redirectUri)
    fun getAccessToken(requestToken: String) = runBlocking {
        client.post<HttpResponse>(PocketEndpoints.ACCESS_TOKEN){
            setPocketHeaders()
            body = AccessTokenRequest(consumerKey, requestToken)
        }.receive<AccessTokenResponse>()
    }
    fun getAuthorizedApi(accessToken: String) = AuthorizedPocketApi(consumerKey, accessToken)
}