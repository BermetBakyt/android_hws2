package com.ber.android_hws.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class SeriesEntity (
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    val name: String,
    val species: String,
    val type: String,
    val gender: String,
    val image: String,
    val url: String,
    val created: String,
    val episode: List<String>
)