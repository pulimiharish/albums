package com.harish.albums.repository

import com.harish.albums.data.Album
import com.harish.albums.db.Database
import io.reactivex.Single
import javax.inject.Inject

class LocalDataSourceImp @Inject constructor(val database: Database) : LocalDataSource {

    override fun getAlbums(): Single<List<Album>> {
        return database.albumsDao().getAllAlbums()
    }

    override fun addAlbums(albums: List<Album>) {
        database.albumsDao().addAllAlbums(albums)
    }

}