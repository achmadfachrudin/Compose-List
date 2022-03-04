package com.achmad.feature.post.data.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserEntity(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "login") val login: String,
    @field:Json(name = "avatar_url") val avatarUrl: String
)
