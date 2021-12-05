package com.tyr.example.kotlinexample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import com.tyr.example.kotlinexample.ApiService.Companion.WEATHER_BASE_URL

import kotlinx.android.synthetic.main.activity_translate.dictionary
import kotlinx.android.synthetic.main.activity_translate.search
import kotlinx.android.synthetic.main.activity_translate.show
import kotlinx.android.synthetic.main.activity_weather.*
import kotlinx.coroutines.*
import okhttp3.Dispatcher
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class WeatherActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_weather)


        search.setOnClickListener {
            val city = dictionary.editableText.toString()
            GlobalScope.launch(Dispatchers.Main) {
                val weather = getWeather(city)
                show.text = weather.result.location.city
                board.text = weather.result.now.toString()
            }
        }

    }

    private suspend fun getWeather(city:String):Weather{
        return withContext(Dispatchers.IO) {
            val retrofit = Retrofit.Builder()
                .baseUrl(WEATHER_BASE_URL) // 设置 网络请求 Url
                .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
                .build()
            val request: ApiService = retrofit.create(ApiService::class.java)
            val observable: Call<Weather?>? = request.getWeather(city)
            var weather = observable?.execute()?.body() as Weather
            return@withContext weather
        }
    }

}
