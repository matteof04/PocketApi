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

package com.github.matteof04.pocketapi.entities.serializers

import com.github.matteof04.pocketapi.entities.ImageHandler
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class ImageHandlerSerializer : KSerializer<ImageHandler> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("ImageHandler", PrimitiveKind.STRING)

    override fun deserialize(decoder: Decoder): ImageHandler = ImageHandler.codeValueOf(decoder.decodeInt())

    override fun serialize(encoder: Encoder, value: ImageHandler) {
        encoder.encodeInt(value.code)
    }
}