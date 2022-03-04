package com.achmad.baseandroid.service

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.achmad.feature.post.data.model.Sort
import com.achmad.feature.post.data.model.User
import kotlinx.coroutines.flow.last

class SearchUserPagingSource(
    private val repository: PostRepository,
    private val query: String,
    private val sort: Sort,
) : PagingSource<Int, User>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, User> {
        return try {
            val pageNumber = params.key ?: 1

            val list = repository.searchUser(
                query,
                sort,
                page = pageNumber
            ).last().data.orEmpty()

            Log.d("PROJECTDEBUG", "PagingSource list ${list.size}")

            val prevKey = if (pageNumber > 1) pageNumber - 1 else null
            val nextKey = if (list.isNotEmpty()) pageNumber + 1 else null

            LoadResult.Page(
                data = list,
                prevKey = prevKey,
                nextKey = nextKey
            )
        } catch (e: Exception) {
            Log.d("PROJECTDEBUG", "PagingSource LoadResult $e")
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, User>): Int? {
        return null
    }
}
