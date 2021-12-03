package com.example.dogtown.network

import com.squareup.moshi.Json


/**
 * This data class defines a RandomDogApiResponse which includes message, and success.
 * The property names of this data class are used by Moshi to match the names of values in JSON.
 */
data class RandomDogApiResponse(
    @Json(name = "message")
    val message: String?,

    @Json(name = "success")
    val success: String?
)