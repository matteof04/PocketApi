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

package com.github.matteof04.pocketapi.entities

import com.github.matteof04.pocketapi.entities.serializers.ImageHandlerSerializer

@kotlinx.serialization.Serializable(with = ImageHandlerSerializer::class)
enum class ImageHandler(val code: Int) {
    NO_IMAGE(0),
    HAS_IMAGE(1),
    IS_IMAGE(2);

    companion object {
        fun codeValueOf(code: Int) = values().firstOrNull { it.code == code } ?: NO_IMAGE
    }
}