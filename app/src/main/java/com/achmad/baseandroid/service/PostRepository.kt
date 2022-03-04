package com.achmad.baseandroid.service

import android.util.Log
import androidx.annotation.WorkerThread
import com.achmad.baseandroid.cache.PostDao
import com.achmad.common.ApiResult
import com.achmad.feature.post.data.mapper.toListUser
import com.achmad.feature.post.data.mapper.toPostItem
import com.achmad.feature.post.data.mapper.toUser
import com.achmad.feature.post.data.model.Sort
import com.skydoves.sandwich.suspendOnError
import com.skydoves.sandwich.suspendOnException
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(
    private val cache: PostDao,
    private val remote: PostRemote
) {

    @WorkerThread
    fun fetchPostList() = flow {
        emit(ApiResult.Loading)

        var posts = cache.getAllPostList()
        if (posts.isEmpty()) {
            val response = remote.fetchPostList()
            Log.d("PROJECTDEBUG", "response $response")

            response.suspendOnSuccess {
                Log.d("PROJECTDEBUG", "suspendOnSuccess")

                posts = data.map {
                    it.toPostItem()
                }
                cache.insertPostList(posts)
                emit(ApiResult.Success(cache.getAllPostList()))
            }.suspendOnError {
                Log.d("PROJECTDEBUG", "suspendOnError $this")
                // handles error cases
                emit(ApiResult.Error(this.toString()))
            }.suspendOnException {
                Log.d("PROJECTDEBUG", "suspendOnException $this")
                // handles exceptional cases
                emit(ApiResult.Error(this.toString()))
            }
        } else {
            Log.d("PROJECTDEBUG", "cache is not empty")
            emit(ApiResult.Success(cache.getAllPostList()))
        }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun fetchUser(
        username: String
    ) = flow {
        emit(ApiResult.Loading)

        val response = remote.fetchUser(username)
        Log.d("PROJECTDEBUG", "response $response")

        response.suspendOnSuccess {
            Log.d("PROJECTDEBUG", "suspendOnSuccess")
            emit(ApiResult.Success(data.toUser()))
        }.suspendOnError {
            Log.d("PROJECTDEBUG", "suspendOnError $this")
            // handles error cases
            emit(ApiResult.Error(this.toString()))
        }.suspendOnException {
            Log.d("PROJECTDEBUG", "suspendOnException $this")
            // handles exceptional cases
            emit(ApiResult.Error(this.toString()))
        }
    }.flowOn(Dispatchers.IO)

    @WorkerThread
    fun searchUser(
        query: String,
        order: Sort,
        page: Int
    ) = flow {
        emit(ApiResult.Loading)

        val response = remote.searchUser(
            query = query,
            order = order.param,
            page = page
        )
        Log.d("PROJECTDEBUG", "response $response")

        response.suspendOnSuccess {
            Log.d("PROJECTDEBUG", "suspendOnSuccess")
            emit(ApiResult.Success(data.toListUser()))
        }.suspendOnError {
            Log.d("PROJECTDEBUG", "suspendOnError $this")
            // handles error cases
            emit(ApiResult.Error(this.toString()))
        }.suspendOnException {
            Log.d("PROJECTDEBUG", "suspendOnException $this")
            // handles exceptional cases
            emit(ApiResult.Error(this.toString()))
        }
    }.flowOn(Dispatchers.IO)
}
