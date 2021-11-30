package com.tyr.example.kotlinexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val fragments:ArrayList<BaseFragment> by lazy {
        ArrayList<BaseFragment>()
    }

    val titles:ArrayList<String> by lazy {
        ArrayList<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fragments?.run {
            add(ToolFragment())
            add(OtherFragment())
        }

        titles?.run {
            add("Tools")
            add("Others")
        }
        val adapter = FragmentsAdapter(supportFragmentManager,lifecycle,fragments)
        viewpager2.adapter = adapter

        TabLayoutMediator(tabs,viewpager2, TabLayoutMediator.TabConfigurationStrategy(){
            tab, position ->
                tab.setText(titles.get(position))
        }).attach()
    }



}