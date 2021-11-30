package com.tyr.example.kotlinexample.utils

import android.content.Context
import android.telecom.TelecomManager
import android.telephony.TelephonyManager

fun getDeviceWidth(context:Context):Int = context.resources.displayMetrics.widthPixels
fun getDeviceHeight(context:Context):Int = context.resources.displayMetrics.heightPixels
fun getIMEI(context:Context):String{
    val tm = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    var deviceId = tm.deviceId
    return deviceId?:"UNKNOWN"
}

fun getDeviceManufacture():String = android.os.Build.MANUFACTURER

fun getDeviceProduct():String = android.os.Build.PRODUCT

fun getDeviceBrand():String = android.os.Build.BRAND

fun getDeviceModel():String = android.os.Build.MODEL

fun getDeviceBoard():String = android.os.Build.BOARD

fun getDeviceDevice():String = android.os.Build.DEVICE

fun getDeviceFubgerprint():String = android.os.Build.FINGERPRINT


