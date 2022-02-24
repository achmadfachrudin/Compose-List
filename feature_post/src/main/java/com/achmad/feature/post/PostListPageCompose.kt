package com.achmad.feature.post

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.items
import com.achmad.baseandroid.theme.component.BaseToolbar
import com.achmad.feature.post.data.model.PostItem

@Composable
fun PostListPageCompose(
    viewModel: PostListViewModel,
    onItemClick: (model: PostItem) -> Unit,
) {
    val lazyItems = viewModel.getPostPagination().collectAsLazyPagingItems()
    var value by remember { mutableStateOf("") }

    Column {
        BaseToolbar(
            title = "List",
            showLeftButton = false
        )
        OutlinedTextField(
            value = value,
            onValueChange = { value = it },
            label = { Text("Enter text") },
            maxLines = 1,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        )
        LazyColumn(
            modifier = Modifier.weight(1f),
        ) {
            items(lazyItems) { model ->
                model?.let {
                    if (model.title.contains(value)) {
                        RowPost(it) { onItemClick(it) }
                    }
                }
            }
        }
    }
}

@Composable
fun RowPost(
    model: PostItem,
    onItemClick: () -> Unit = {},
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 16.dp)
            .clickable(onClick = onItemClick),
    ) {
        Text(
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 24.sp,
                letterSpacing = 0.sp
            ),
            text = model.title
        )
        Text(text = model.body)
    }
}
