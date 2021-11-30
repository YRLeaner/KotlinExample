package com.tyr.example.kotlinexample

import android.animation.Animator
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.ViewGroup
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView

class SplashActivity:AppCompatActivity() {


    private var mLottieAnimationView: LottieAnimationView? = null

    private var mSplashContainer: ViewGroup? = null

    private var mContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mContext = getApplicationContext()
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        setContentView(R.layout.activity_splash)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        mSplashContainer = findViewById<ViewGroup>(R.id.splash_container)
        initView()

    }

    private fun initView() {
        mLottieAnimationView = findViewById<LottieAnimationView>(R.id.splash_animation)
        mLottieAnimationView!!.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animator: Animator) {}
            override fun onAnimationEnd(animator: Animator) {
                startIntent()
            }
            override fun onAnimationCancel(animator: Animator) {}
            override fun onAnimationRepeat(animator: Animator) {}
        })
    }

    private fun startIntent() {
        Intent(this, MainActivity::class.java).apply {
            startActivity(this)
            finish()
        }
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)

    }

}