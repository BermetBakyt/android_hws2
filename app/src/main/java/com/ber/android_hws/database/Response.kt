package com.ber.android_hws.database

data class Response(
    val episodes: List<Episode>
)
    data class Episode(
    val episode_id: Long?,
    val title: String?,
    val season: Long?,
    val air_date: String,
    val characters: List<String>,
    val episode: Long?,
    val series: String?
)