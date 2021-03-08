package com.harish.albums.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albumsTable")
data class Album(
	val userId: Int,
	@PrimaryKey
	val id: Int,
	val title: String
)