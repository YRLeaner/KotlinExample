package com.tyr.example.kotlinexample

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_translate.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ArchiveActivity : AppCompatActivity() {


    val viewModel:TranslationViewModel by lazy {
        ViewModelProvider(this).get(TranslationViewModel::class.java)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_translate)
        val retrofit = Retrofit.Builder()
            .baseUrl("https://fanyi.youdao.com/") // 设置 网络请求 Url
            .addConverterFactory(GsonConverterFactory.create()) //设置使用Gson解析(记得加入依赖)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) // 支持RxJava
            .build()
        val request: ApiService = retrofit.create(ApiService::class.java)

        search.setOnClickListener {
            val word = dictionary.editableText.toString()
            val observable: Observable<Translation?>? = request.getCall(word)
            observable?.subscribeOn(Schedulers.io())               // 在IO线程进行网络请求
                ?.observeOn(AndroidSchedulers.mainThread())
                ?.subscribe(TranslationObserver())
        }

        viewModel.result.observe(this, androidx.lifecycle.Observer<TranslationResult> {
            board.text = it.tgt
            show.text = it.src
        })

    }

    inner class TranslationObserver: io.reactivex.Observer<Translation?> {

        override fun onComplete() {
            Log.d("TAG", "请求成功");
        }

        override fun onSubscribe(d: Disposable?) {
            Log.d("TAG", "开始采用subscribe连接");
        }

        override fun onNext(value: Translation?) {
            Log.d("TAG", value.toString());
            value?.translateResult?.flatMap { it->it.asIterable() }
                ?.forEach{
                    println(it.toString())
                    viewModel.result.value = it as TranslationResult
                }
        }

        override fun onError(e: Throwable?) {
            Log.d("TAG", "请求失败");
        }

    }


}
