package com.ber.android_hws

class Response {
    data class RepoResult(
        val items: List<Episode>
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
}