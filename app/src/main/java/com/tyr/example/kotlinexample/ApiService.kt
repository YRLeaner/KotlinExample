package com.tyr.example.kotlinexample

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    @GET("https://fanyi.youdao.com/translate?&doctype=json")
    fun getCall(@Query("i") i:String): Observable<Translation?>?
}