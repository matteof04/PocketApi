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

import com.github.matteof04.pocketapi.entities.Tags
import com.github.matteof04.pocketapi.entities.add.AddRequest
import com.github.matteof04.pocketapi.entities.add.AddResponse
import com.github.matteof04.pocketapi.entities.modify.Action
import com.github.matteof04.pocketapi.entities.modify.ModifyRequest
import com.github.matteof04.pocketapi.entities.modify.ModifyResponse
import com.github.matteof04.pocketapi.entities.retrieve.*
import com.github.matteof04.pocketapi.util.PocketEndpoints
import com.github.matteof04.pocketapi.util.setPocketHeaders
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import kotlinx.coroutines.runBlocking

class AuthorizedPocketApi(consumerKey: String, private val accessToken: String) : PocketApi(consumerKey) {
    fun add(url: String, title: String = "", tweetId: String = "", tags: Tags) = runBlocking {
        client.post<HttpResponse>(PocketEndpoints.ADD){
            setPocketHeaders()
            body = AddRequest(url, consumerKey, accessToken, title, tweetId, tags)
        }.receive<AddResponse>()
    }
    fun retrieve(parameters: RetrieveParameters) = runBlocking {
        client.post<HttpResponse>(PocketEndpoints.GET){
            setPocketHeaders()
            body = RetrieveRequest.fromRetrieveParameters(consumerKey, accessToken, parameters)
        }.receive<RetrieveResponse>()
    }
    fun modify(actions: Array<Action>) = runBlocking {
        client.post<HttpResponse>(PocketEndpoints.MODIFY){
            setPocketHeaders()
            body = ModifyRequest(consumerKey, accessToken, actions)
        }.receive<ModifyResponse>()
    }
}