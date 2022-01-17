package com.achmad.baseandroid.service

import com.achmad.feature.post.data.entity.PostItemEntity
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun fetchPostList(
    ): ApiResponse<List<PostItemEntity>>
}
