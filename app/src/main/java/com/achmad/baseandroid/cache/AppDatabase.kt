package com.achmad.baseandroid.cache

import androidx.room.Database
import androidx.room.RoomDatabase
import com.achmad.feature.post.data.model.PostItem

@Database(entities = [PostItem::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {

    abstract fun postDao(): PostDao
}
