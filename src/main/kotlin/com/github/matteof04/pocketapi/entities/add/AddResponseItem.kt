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

import com.github.matteof04.pocketapi.entities.ImageHandler
import com.github.matteof04.pocketapi.entities.VideoHandler
import com.github.matteof04.pocketapi.entities.add.serializers.LocalDateTimeSerializer
import com.github.matteof04.pocketapi.entities.serializers.IntegerBooleanSerializer
import kotlinx.serialization.SerialName
import java.time.LocalDateTime

@kotlinx.serialization.Serializable
data class AddResponseItem(
    @SerialName("item_id") val itemId: Long = -1,
    @SerialName("normal_url") val normalUrl: String = "",
    @SerialName("resolved_id") val resolvedId: String = "",
    @SerialName("resolved_url") val resolvedUrl: String = "",
    @SerialName("domain_id") val domainId: Long = -1,
    @SerialName("origin_domain_id") val originDomainId: Long = -1,
    @SerialName("response_code") val responseCode: Int = -1,
    @SerialName("mime_type") val mimeType: String = "",
    @SerialName("content_length") val contentLength: Int = -1,
    val encoding: String = "",
    @kotlinx.serialization.Serializable(with= LocalDateTimeSerializer::class)
    @SerialName("date_resolved") val dateResolved: LocalDateTime? = null,
    @kotlinx.serialization.Serializable(with= LocalDateTimeSerializer::class)
    @SerialName("date_published") val datePublished: LocalDateTime? = null,
    val title: String = "",
    val excerpt: String = "",
    @SerialName("word_count") val wordCount: Int = -1,
    @SerialName("has_image") val hasImage: ImageHandler = ImageHandler.NO_IMAGE,
    @SerialName("has_video") val hasVideo: VideoHandler = VideoHandler.NO_VIDEO,
    @kotlinx.serialization.Serializable(with = IntegerBooleanSerializer::class)
    @SerialName("is_index") val isIndex: Boolean? = null,
    @kotlinx.serialization.Serializable(with = IntegerBooleanSerializer::class)
    @SerialName("is_article") val isArticle: Boolean? = null
)
