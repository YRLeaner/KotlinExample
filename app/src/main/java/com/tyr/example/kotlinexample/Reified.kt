package com.wjx.android.wanandroidmvvm.common.utils

import android.content.Context
import android.content.Intent
import android.util.Log
import com.tyr.example.kotlinexample.ArchiveActivity
import com.tyr.example.kotlinexample.CalCulateActivity
import com.tyr.example.kotlinexample.ToolActivityEnum

/**
 * Created with Android Studio.
 * Description:
 * @author: Wangjianxian
 * @CreateDate: 2020/5/1 16:34
 */

inline fun <reified T> startActivity(context: Context) {
    val intent = Intent(context, T::class.java)
    context.startActivity(intent)
}

inline fun <reified T> startActivity(context: Context, block: Intent.() -> Unit) {
    val intent = Intent(context, T::class.java)
    intent.block()
    context.startActivity(intent)
}

inline fun startActivity(context: Context, type:ToolActivityEnum){
        when(type){
            ToolActivityEnum.Calculator->
                startActivity<CalCulateActivity>(context)
            ToolActivityEnum.Archive->
                startActivity<ArchiveActivity>(context)
            else->
                Log.d("TODO","TODO()")
        }
}