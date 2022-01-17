package com.achmad.feature.post.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class PostItem(
    @PrimaryKey val id: Int,
    var userId: Int,
    val title: String,
    val body: String
) : Parcelable
