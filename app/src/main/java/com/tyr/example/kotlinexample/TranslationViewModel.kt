package com.tyr.example.kotlinexample

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TranslationViewModel:ViewModel() {

    val result: MutableLiveData<TranslationResult> = MutableLiveData<TranslationResult>()

}