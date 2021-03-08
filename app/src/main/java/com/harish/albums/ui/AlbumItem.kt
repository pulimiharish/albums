package com.harish.albums.ui

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.harish.albums.data.Album

@Composable
fun AlbumItem(album: Album) {
    Card(
        shape = RoundedCornerShape(4.dp),
        backgroundColor = Color.White,
    ) {
        Row {
            Text(
                text = album.title,
                modifier = Modifier.padding(4.dp),
                style = TextStyle(fontSize = 20.sp, color = Color.Black),
                textAlign = TextAlign.Left
            )
        }
    }
}