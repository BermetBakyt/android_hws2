package com.ber.android_hws.database

data class ResponseDto (
    val results: List<CharacterDto>
        )

data class CharacterDto(
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

class Response {
    data class RepoResult(
        val items: List<Character>
    )

    data class Character(
        val episode_id: Long?,
        val title: String?,
        val season: Long?,
        val air_date: String,
        val characters: List<String>,
        val episode: Long?,
        val series: String?
    )
}