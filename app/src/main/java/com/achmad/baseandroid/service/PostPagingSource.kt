package com.achmad.baseandroid.service

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.achmad.feature.post.data.model.PostItem
import kotlinx.coroutines.flow.last

class PostPagingSource(
    private val repository: PostRepository
) : PagingSource<Int, PostItem>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, PostItem> {
        return try {
            val list = repository.fetchPostList().last().data.orEmpty()
            Log.d("PROJECTDEBUG", "PagingSource list ${list.size}")

            LoadResult.Page(
                data = list,
                prevKey = null,
                nextKey = null
            )
        } catch (e: Exception) {
            Log.d("PROJECTDEBUG", "PagingSource LoadResult $e")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, PostItem>): Int? {
        return null
    }
}
