package com.tyr.example.kotlinexample

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tyr.example.kotlinexample.utils.getDeviceBrand
import com.tyr.example.kotlinexample.utils.getDeviceHeight
import com.tyr.example.kotlinexample.utils.getDeviceModel
import com.tyr.example.kotlinexample.utils.getDeviceWidth


class DeviceModelFactory(val context:Context):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Context::class.java).newInstance(context)
    }
}
class DeviceModel(context:Context):ViewModel() {

    val deviceWidth:Int by lazy {
        getDeviceWidth(context)
    }

    val deviceHeight:Int by lazy {
        getDeviceHeight(context)
    }

    val deviceBrand:String by lazy {
        getDeviceBrand()
    }

    val deviceModel:String by lazy {
        getDeviceModel()
    }


}