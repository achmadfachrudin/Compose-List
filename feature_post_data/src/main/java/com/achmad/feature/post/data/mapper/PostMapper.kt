package com.achmad.feature.post.data.mapper

import com.achmad.feature.post.data.entity.PostItemEntity
import com.achmad.feature.post.data.entity.SearchUserEntity
import com.achmad.feature.post.data.entity.UserEntity
import com.achmad.feature.post.data.model.PostItem
import com.achmad.feature.post.data.model.User

fun PostItemEntity.toPostItem(): PostItem {
    return PostItem(
        id = id,
        userId = userId,
        title = title,
        body = body
    )
}

fun UserEntity.toUser(): User {
    return User(
        id = id,
        username = login,
        avatar = avatarUrl.ifEmpty {
            "https://ui-avatars.com/api/?name=$login&background=e8e8e8&color=4a4a4a"
        },
    )
}

fun SearchUserEntity.toListUser(): List<User> {
    return items.map { userEntity ->
        User(
            id = userEntity.id,
            username = userEntity.login,
            avatar = userEntity.avatarUrl,
        )
    }
}
