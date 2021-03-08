package com.harish.albums.repository

import com.harish.albums.data.Album
import io.reactivex.Single

interface RemoteDataSource {
    fun getAlbums(): Single<List<Album>>
}