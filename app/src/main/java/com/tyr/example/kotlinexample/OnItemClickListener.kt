package com.tyr.example.kotlinexample

import android.view.View

interface OnItemClickListener {
    fun onItemClick(view: View, position: Int, t: Tool)
    fun onItemLongClick(view: View, position: Int,t: Tool):Boolean
}