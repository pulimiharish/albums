package com.harish.albums.repository

import com.harish.albums.data.Album
import io.reactivex.Single

interface LocalDataSource {
    fun getAlbums(): Single<List<Album>>

    fun addAlbums(albums: List<Album>)
}