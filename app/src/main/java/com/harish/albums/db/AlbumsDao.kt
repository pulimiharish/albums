package com.harish.albums.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.harish.albums.data.Album
import io.reactivex.Single

@Dao
interface AlbumsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addAllAlbums(albums: List<Album>)

    @Query("SELECT * FROM albumsTable")
    fun getAllAlbums(): Single<List<Album>>
}