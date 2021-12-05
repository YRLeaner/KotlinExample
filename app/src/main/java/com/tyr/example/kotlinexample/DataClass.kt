package com.tyr.example.kotlinexample

data class Tool(val name:String, val color:Int, val type:ToolActivityEnum)

data class Translation(val type:String,val errorCode:Int,val elapsedTime:Int,val translateResult : List<List<TranslationResult>>)

data class TranslationResult(val src : String, val tgt : String)

data class Weather(val status:Int,val result:WeatherResult)
data class WeatherResult(val location: WeatherLocation,val now:WeatherNow)
data class WeatherLocation(val country:String,val province:String,val city:String)
data class WeatherNow(val text:String,val temp:Int,val wind_dir:String)