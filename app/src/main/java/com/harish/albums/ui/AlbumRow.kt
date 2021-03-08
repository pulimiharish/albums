package com.harish.albums.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.harish.albums.data.Album

@Composable
fun AlbumRow(
    modifier: Modifier = Modifier,
    listItems: List<Album>,
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp, 16.dp, 16.dp)
    ) {
        items(listItems) {
            AlbumItem(album = it)
            Spacer(modifier = Modifier
                .fillMaxWidth()
                .height(16.dp))
        }
    }
}