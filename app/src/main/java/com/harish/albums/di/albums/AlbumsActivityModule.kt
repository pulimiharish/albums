package com.harish.albums.di.albums

import androidx.lifecycle.ViewModelProviders
import com.harish.albums.repository.AlbumsRepository
import com.harish.albums.repository.AlbumsRepositoryImp
import com.harish.albums.repository.LocalDataSource
import com.harish.albums.repository.RemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(ViewModelComponent::class)
object AlbumsActivityModule {

    @Provides
    @ViewModelScoped
    fun provideAlbumRepository(
        remoteDataSource: RemoteDataSource,
        localDataSource: LocalDataSource
    ): AlbumsRepository = AlbumsRepositoryImp(remoteDataSource, localDataSource)

}