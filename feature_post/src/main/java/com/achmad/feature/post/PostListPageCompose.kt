package com.achmad.feature.post

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BottomSheetScaffold
import androidx.compose.material.BottomSheetState
import androidx.compose.material.BottomSheetValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Sort
import androidx.compose.material.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.achmad.baseandroid.theme.component.BaseToolbar
import com.achmad.feature.post.PostListViewModel.State
import com.achmad.feature.post.data.model.Sort
import com.achmad.feature.post.data.model.User
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun PostListPageCompose(
    viewModel: PostListViewModel,
    onSortChanged: (sort: Sort) -> Unit = {},
    onSearchChanged: (query: String) -> Unit = {},
    onLoadMore: () -> Unit = {},
    onItemClick: (model: User) -> Unit,
) {

    val state by viewModel.state.observeAsState(State())
    val focusManager = LocalFocusManager.current

    val bottomSheetScaffoldState = rememberBottomSheetScaffoldState(
        bottomSheetState = BottomSheetState(BottomSheetValue.Collapsed)
    )
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            BaseToolbar(
                title = state.username,
                showLeftButton = false,
                showRightButton = true,
                rightButtonImage = Icons.Filled.Sort,
                onRightButtonClick = {
                    coroutineScope.launch {
                        if (bottomSheetScaffoldState.bottomSheetState.isCollapsed) {
                            bottomSheetScaffoldState.bottomSheetState.expand()
                        } else {
                            bottomSheetScaffoldState.bottomSheetState.collapse()
                        }
                    }
                }
            )
        },
        content = {
            Column {
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    value = state.query,
                    onValueChange = {
                        onSearchChanged(it)
                    },
                    label = { Text("Enter username") },
                    maxLines = 1,
                    keyboardActions = KeyboardActions(
                        onDone = { focusManager.clearFocus() }
                    ),
                    keyboardOptions = KeyboardOptions.Default.copy(
                        imeAction = ImeAction.Done
                    )
                )

                BottomSheetScaffold(
                    scaffoldState = bottomSheetScaffoldState,
                    sheetContent = {
                        SortDialogView(
                            onSortClick = {
                                coroutineScope.launch {
                                    onSortChanged(it)
                                    bottomSheetScaffoldState.bottomSheetState.collapse()
                                }
                            }
                        )
                    },
                    sheetPeekHeight = 0.dp,
                    backgroundColor = MaterialTheme.colors.background,
                    content = {
                        when (state.displayState) {
                            State.DisplayState.Content -> {
                                LazyColumn {
                                    items(state.displayItems) { model ->
                                        RowPost(model) { onItemClick(model) }
                                    }

                                    if (state.showLoadMore) {
                                        item {
                                            LinearProgressIndicator(
                                                modifier = Modifier.fillMaxWidth()
                                            )
                                            onLoadMore()
                                        }
                                    }
                                }
                            }
                            State.DisplayState.Empty -> {
                                Text(
                                    style = TextStyle(
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 24.sp,
                                        letterSpacing = 0.sp
                                    ),
                                    text = "\"${state.query}\" not found"
                                )
                            }
                            State.DisplayState.Error -> {
                                Text(
                                    style = TextStyle(
                                        fontWeight = FontWeight.Normal,
                                        fontSize = 24.sp,
                                        letterSpacing = 0.sp
                                    ),
                                    text = "Oops, something wrong"
                                )
                            }
                            State.DisplayState.Loading -> {
                                LinearProgressIndicator(
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                )
            }
        }
    )
}
