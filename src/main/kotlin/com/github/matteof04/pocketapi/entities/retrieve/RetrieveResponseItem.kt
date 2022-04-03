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

import com.github.matteof04.pocketapi.entities.ImageHandler
import com.github.matteof04.pocketapi.entities.VideoHandler
import com.github.matteof04.pocketapi.entities.serializers.IntegerBooleanSerializer
import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RetrieveResponseItem(
    @SerialName("item_id") val itemId: Long = -1,
    @SerialName("resolved_id") val resolvedId: String = "",
    @SerialName("given_url") val givenUrl: String = "",
    @SerialName("resolved_url") val resolvedUrl: String = "",
    @SerialName("given_title") val givenTitle: String = "",
    @SerialName("resolved_title") val resolvedTitle: String = "",
    @kotlinx.serialization.Serializable(with = IntegerBooleanSerializer::class)
    val favorite: Boolean? = null,
    val status: ItemStatus = ItemStatus.NORMAL,
    val excerpt: String = "",
    @kotlinx.serialization.Serializable(with = IntegerBooleanSerializer::class)
    @SerialName("is_article") val isArticle: Boolean? = null,
    @SerialName("has_image") val hasImage: ImageHandler = ImageHandler.NO_IMAGE,
    @SerialName("has_video") val hasVideo: VideoHandler = VideoHandler.NO_VIDEO,
    @SerialName("word_count") val wordCount: Int = -1
)
