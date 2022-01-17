package com.achmad.feature.post

import androidx.lifecycle.ViewModel
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.achmad.baseandroid.service.PostPagingSource
import com.achmad.baseandroid.service.PostRepository
import com.achmad.feature.post.data.model.PostItem
import dagger.hilt.android.scopes.ActivityScoped
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@ActivityScoped
class PostListViewModel @Inject constructor(
    private val postRepository: PostRepository
) : ViewModel() {

    fun getPostPagination(): Flow<PagingData<PostItem>> {
        return Pager(PagingConfig(pageSize = 20)) {
            PostPagingSource(postRepository)
        }.flow
    }
}
