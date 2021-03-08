package com.harish.albums.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.harish.albums.data.Album
import com.harish.albums.repository.AlbumsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.disposables.CompositeDisposable
import javax.inject.Inject

@HiltViewModel
class AlbumsViewModel @Inject constructor(private val albumsRepository: AlbumsRepository) : ViewModel() {

    private val compositeDisposable = CompositeDisposable()
    private val albumsObservable: MutableLiveData<List<Album>> = MutableLiveData()
    private val showProgressDialog: MutableLiveData<Boolean> = MutableLiveData()
    private val errorObservable: MutableLiveData<String> = MutableLiveData()

    fun getAlbums(isConnected: Boolean) {
        val observable = if (isConnected) albumsRepository.getAlbumsSortedAlbums()
        else albumsRepository.getDataFromDb()

        compositeDisposable.add(
            observable
                .doOnSubscribe { showProgressDialog.value = true }
                .doOnComplete { showProgressDialog.value = false }
                .doOnError { showProgressDialog.value = false }
                .subscribe({ albums -> albumsObservable.value = albums },
                    { error -> errorObservable.value = error.message.toString() })
        )
    }

    fun albumsObservable(): LiveData<List<Album>> = albumsObservable

    fun progressObservable(): LiveData<Boolean> = showProgressDialog

    fun errorObservable(): LiveData<String> = errorObservable

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }
}