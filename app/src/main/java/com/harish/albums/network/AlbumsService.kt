package com.harish.albums.network

import com.harish.albums.data.Album
import io.reactivex.Single
import retrofit2.http.GET

interface AlbumsService {

    @GET("albums")
    fun getAlbums(): Single<List<Album>>
}