package com.tyr.example.kotlinexample

import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


interface ApiService {

    companion object{
        var TRANSLATE_BASE_URL = "https://fanyi.youdao.com/"
        var WEATHER_BASE_URL = "https://api2.jirengu.com/"
    }
    @GET("translate?&doctype=json")
    fun getCall(@Query("i") i:String): Observable<Translation?>?

    @GET("getWeather.php")
    fun getWeather(@Query("id") city:String): Call<Weather?>?

}