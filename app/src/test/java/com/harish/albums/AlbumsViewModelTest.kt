package com.harish.albums

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.harish.albums.data.Album
import com.harish.albums.repository.AlbumsRepository
import com.harish.albums.viewmodel.AlbumsViewModel
import io.reactivex.Observable
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class AlbumsViewModelTest {
    @Rule
    @JvmField
    var rule: TestRule = InstantTaskExecutorRule()

    @Mock
    lateinit var albumsRepository: AlbumsRepository

    private lateinit var viewModel: AlbumsViewModel

    @Mock
    private lateinit var albumObserver: Observer<List<Album>>

    @Mock
    private lateinit var errorObserver: Observer<String>

    @Mock
    private lateinit var progress: Observer<Boolean>

    @Before
    fun setup() {
        viewModel = AlbumsViewModel(albumsRepository)
        viewModel.albumsObservable().observeForever(albumObserver)
        viewModel.progressObservable().observeForever(progress)
        viewModel.errorObservable().observeForever(errorObserver)
    }

    @Test
    fun getAlbumSuccess() {

        val albums = listOf(Album(1, 1, "Album 1"), Album(2, 2, "Album 2"))
        `when`(albumsRepository.getAlbumsSortedAlbums()).thenReturn(Observable.just(albums))

        viewModel.getAlbums(true)

        verify(albumObserver, times(1)).onChanged(albums)
        verify(errorObserver, times(0)).onChanged(ArgumentMatchers.any())
        verify(progress, times(1)).onChanged(true)
        verify(progress, times(1)).onChanged(false)
    }

    @Test
    fun getAlbumError() {

        val errorMessage = "Exception"
        `when`(albumsRepository.getAlbumsSortedAlbums()).thenReturn(
            Observable.error(
                RuntimeException(errorMessage)
            )
        )

        viewModel.getAlbums(true)

        verify(albumObserver, times(0)).onChanged(ArgumentMatchers.any())
        verify(errorObserver, times(1)).onChanged(errorMessage)
        verify(progress, times(1)).onChanged(true)
        verify(progress, times(1)).onChanged(false)
    }

}

