package com.harish.albums.di.app

import android.app.Application
import androidx.room.Room
import com.harish.albums.common.Constants
import com.harish.albums.db.Database
import com.harish.albums.repository.LocalDataSource
import com.harish.albums.repository.LocalDataSourceImp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideAppDataBase(application: Application): Database {
        return Room.databaseBuilder(application, Database::class.java, Constants.DATABASE_NAME)
            .allowMainThreadQueries().build()
    }

    @Provides
    @Singleton
    fun provideLocalDataSource(database: Database): LocalDataSource {
        return LocalDataSourceImp(database)
    }
}