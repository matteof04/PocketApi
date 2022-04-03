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

package com.github.matteof04.pocketapi.entities.modify

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class ModifyResponse(
    val status: Int,
    @SerialName("action_results") val actionResults: Array<Boolean>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as ModifyResponse

        if (status != other.status) return false
        if (!actionResults.contentEquals(other.actionResults)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = status
        result = 31 * result + actionResults.contentHashCode()
        return result
    }
}
