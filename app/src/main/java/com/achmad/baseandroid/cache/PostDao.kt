package com.achmad.baseandroid.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.achmad.feature.post.data.model.PostItem

@Dao
interface PostDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPostList(postList: List<PostItem>)

    @Query("SELECT * FROM PostItem WHERE title = :title_")
    suspend fun getPostList(title_: String): List<PostItem>

    @Query("SELECT * FROM PostItem")
    suspend fun getAllPostList(): List<PostItem>
}
