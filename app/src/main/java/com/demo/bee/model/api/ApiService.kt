package com.demo.bee.model.api

import com.demo.bee.model.api.response.SourceResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query


interface ApiService {
    @Headers(
        "Cache-Control: no-cache",
        "Cache-Control: no-store",
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("sources")
    fun callApiRXSources(@Query("language") language: String?): Observable<SourceResponse?>?
}