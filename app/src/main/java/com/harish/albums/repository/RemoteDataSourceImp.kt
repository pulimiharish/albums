package com.harish.albums.repository

import com.harish.albums.data.Album
import com.harish.albums.network.AlbumsService
import io.reactivex.Single
import javax.inject.Inject

class RemoteDataSourceImp @Inject constructor(private val albumsService: AlbumsService) :
    RemoteDataSource {

    override fun getAlbums(): Single<List<Album>> {
        return albumsService.getAlbums()
    }
}