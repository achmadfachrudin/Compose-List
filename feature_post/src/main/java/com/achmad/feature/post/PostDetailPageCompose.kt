package com.achmad.feature.post

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import com.achmad.baseandroid.theme.component.BaseToolbar
import com.achmad.feature.post.data.model.User

@Composable
fun PostDetailPageCompose(
    model: User,
) {
    Column {
        BaseToolbar(
            title = "Detail",
            showLeftButton = false
        )
        RowPost(model) { }
    }
}
