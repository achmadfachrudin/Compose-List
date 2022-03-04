package com.achmad.feature.post.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    val id: Long,
    var username: String,
    val avatar: String,
) : Parcelable
