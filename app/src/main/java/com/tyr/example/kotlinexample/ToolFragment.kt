package com.tyr.example.kotlinexample

import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import com.wjx.android.wanandroidmvvm.common.utils.startActivity
import kotlinx.android.synthetic.main.fragment_tool.*

class ToolFragment:BaseFragment() {

    override fun getLayoutId(): Int {
        return R.layout.fragment_tool
    }

    override fun initView() {
        recyclerview.layoutManager = GridLayoutManager(context,2)
        val adapter = GrideLayoutAdapter(context)
        adapter.setOnItemClickListener(object : OnItemClickListener {
            override fun onItemClick(view: View, position: Int, t: Tool) {
                Log.d("ToolFragment","click()")
                context?.let {
                    startActivity(it,t.type)
                    Toast.makeText(it,t.name,Toast.LENGTH_LONG).show()
                }

            }

            override fun onItemLongClick(view: View, position: Int, t: Tool): Boolean {
                Toast.makeText(context,"long click",Toast.LENGTH_LONG).show()
                return true
            }

        })
        recyclerview.adapter = adapter

    }

}

