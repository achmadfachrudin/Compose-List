package com.achmad.feature.post.data.mapper

import com.achmad.feature.post.data.entity.PostItemEntity
import com.achmad.feature.post.data.model.PostItem

fun PostItemEntity.toPostItem(): PostItem {
    return PostItem(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}
