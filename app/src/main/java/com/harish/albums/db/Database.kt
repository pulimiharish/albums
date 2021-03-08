package com.harish.albums.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.harish.albums.common.Constants
import com.harish.albums.data.Album

@Database(entities = [Album::class], version = Constants.DATABASE_VERSION, exportSchema = false)
abstract class Database : RoomDatabase() {
    abstract fun albumsDao():AlbumsDao
}