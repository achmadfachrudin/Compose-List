package com.achmad.baseandroid.service

import com.achmad.feature.post.data.entity.PostItemEntity
import com.achmad.feature.post.data.entity.SearchUserEntity
import com.achmad.feature.post.data.entity.UserEntity
import com.skydoves.sandwich.ApiResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface PostService {

    @GET("posts")
    suspend fun fetchPostList(): ApiResponse<List<PostItemEntity>>

    @GET("users/{username}")
    suspend fun fetchUser(
        @Path("username") username: String
    ): ApiResponse<UserEntity>

    @GET("search/users")
    suspend fun searchUser(
        @Query("q") query: String,
        @Query("order") order: String,
        @Query("page") page: Int,
    ): ApiResponse<SearchUserEntity>
}
