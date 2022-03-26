package com.ber.android_hws.database

import com.ber.android_hws.database.Response
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface SeriesApi {
    @GET("episodes")
    fun getRepositories(): Observable<List<Response.RepoResult>>
    @GET("episodes/{id}")
    fun getEpisodeById(@Path("id") id: Long): Single<List<Episode>>
}
