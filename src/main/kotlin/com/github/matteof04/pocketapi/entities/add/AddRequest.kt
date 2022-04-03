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

package com.github.matteof04.pocketapi.entities.add

import com.github.matteof04.pocketapi.entities.Tags
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class AddRequest(
    val url: String,
    @SerialName("consumer_key") val consumerKey: String,
    @SerialName("access_token") val accessToken: String,
    val title: String = "",
    @SerialName("tweet_id") val tweetId: String = "",
    val tags: Tags = Tags(),
)