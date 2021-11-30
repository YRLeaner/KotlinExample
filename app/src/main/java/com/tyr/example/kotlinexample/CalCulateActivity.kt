package com.tyr.example.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_calculate.*


class CalCulateActivity : AppCompatActivity() {

    val deviceModel: DeviceModel by lazy {
        ViewModelProvider(this,DeviceModelFactory(this)).get(DeviceModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculate)
        initView()


    }

    fun initView() {
        device.text = deviceModel.deviceModel
        custom.text = deviceModel.deviceBrand
        hardware.text = "Height:${deviceModel.deviceHeight}   Width:${deviceModel.deviceWidth}"
    }

}