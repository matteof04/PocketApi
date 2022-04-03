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

data class RetrieveParameters(
    val state: State = State.UNREAD,
    @kotlinx.serialization.Serializable(with = IntegerBooleanSerializer::class)
    val favorite: Boolean? = null,
    val tag: String? = null,
    val contentType: ContentType? = null,
    val sort: Sort? = null,
    val detailType: DetailType? = null,
    val search: String? = null,
    val domain: String? = null,
    val since: Long? = null,
    val count: Int? = null,
    val offset: Int? = null
)
