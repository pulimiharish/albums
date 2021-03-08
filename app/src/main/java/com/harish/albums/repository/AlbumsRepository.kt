package com.harish.albums.repository

import com.harish.albums.data.Album
import io.reactivex.Observable

interface AlbumsRepository {
    fun getAlbumsSortedAlbums(): Observable<List<Album>>

    fun getDataFromDb(): Observable<List<Album>>
}