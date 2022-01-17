package com.achmad.baseandroid.service

import com.achmad.feature.post.data.entity.PostItemEntity
import com.skydoves.sandwich.ApiResponse
import javax.inject.Inject

class PostRemote @Inject constructor(
    private val service: PostService
) {

    suspend fun fetchPostList(
    ): ApiResponse<List<PostItemEntity>> = service.fetchPostList()
}
