package com.tyr.example.kotlinexample

data class Tool(val name:String, val color:Int, val type:ToolActivityEnum)

data class Translation(val type:String,val errorCode:Int,val elapsedTime:Int,val translateResult : List<List<TranslationResult>>)

data class TranslationResult(val src : String, val tgt : String)