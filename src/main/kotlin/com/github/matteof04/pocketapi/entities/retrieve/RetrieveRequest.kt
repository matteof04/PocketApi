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

package com.github.matteof04.pocketapi.entities.retrieve

import com.github.matteof04.pocketapi.entities.serializers.IntegerBooleanSerializer
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RetrieveRequest(
    @SerialName("consumer_key") val consumerKey: String,
    @SerialName("access_token") val accessToken: String,
    val state: State = State.UNREAD,
    @kotlinx.serialization.Serializable(with = IntegerBooleanSerializer::class)
    val favorite: Boolean? = null,
    val tag: String? = null,
    @SerialName("content_type") val contentType: ContentType? = null,
    val sort: Sort? = null,
    @SerialName("detail_type") val detailType: DetailType? = null,
    val search: String? = null,
    val domain: String? = null,
    val since: Long? = null,
    val count: Int? = null,
    val offset: Int? = null
){
    companion object {
        fun fromRetrieveParameters(consumerKey: String, accessToken: String, parameters: RetrieveParameters): RetrieveRequest {
            return with(parameters){
                RetrieveRequest(consumerKey, accessToken, state, favorite, tag, contentType, sort, detailType, search, domain, since, count, offset)
            }
        }
    }
}
