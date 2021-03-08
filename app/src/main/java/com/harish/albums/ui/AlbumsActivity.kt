package com.harish.albums.ui

import android.os.Bundle
import android.widget.Toast
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.annotation.VisibleForTesting
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.harish.albums.common.Util
import com.harish.albums.viewmodel.AlbumsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AlbumsActivity : AppCompatActivity() {

    @VisibleForTesting
    val albumsActivityViewModel: AlbumsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CircularIndeterminateProgressBar(isDisplayed = true)
        }

        getAlbums()
        setObservers()
    }

    private fun getAlbums() {
        albumsActivityViewModel.getAlbums(Util.isConnected(this))
    }

    private fun setObservers() {
        albumsActivityViewModel.albumsObservable().observe(this,
            Observer {
                setContent {
                    Thread.sleep(2000)
                    AlbumRow(listItems = it)
                    CircularIndeterminateProgressBar(isDisplayed = false)
                }
            })

        albumsActivityViewModel.errorObservable().observe(this,
            Observer {
                Toast.makeText(this, it.toString(), Toast.LENGTH_LONG).show()
            })
    }

}
