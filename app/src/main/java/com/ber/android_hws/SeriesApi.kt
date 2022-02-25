package com.ber.android_hws

import android.content.ClipData
import com.ber.android_hws.Response.RepoResult
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.GET

interface SeriesApi {
    @GET("/episodes")
    fun getRepositories(): Observable<List<Response.Episode>>
}
