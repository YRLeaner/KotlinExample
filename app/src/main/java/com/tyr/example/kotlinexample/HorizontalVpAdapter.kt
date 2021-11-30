package com.tyr.example.kotlinexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView

class HorizontalVpAdapter(mContext:Context): RecyclerView.Adapter<HorizontalVpAdapter.HorizontalVpViewHolder>() {

    val backgrounds:ArrayList<Int> by lazy {
        ArrayList<Int>()
    }



    var context:Context? = mContext
    init {
        backgrounds?.let {
            it.add(android.R.color.holo_blue_bright);
            it.add(android.R.color.holo_red_dark);
            it.add(android.R.color.holo_green_dark);
            it.add(android.R.color.holo_orange_light);
            it.add(android.R.color.holo_purple);
        }
    }


    class HorizontalVpViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mLinearLayout:LinearLayout = itemView.findViewById(R.id.ll_h_v);
        var mTextView:TextView = itemView.findViewById(R.id.tv_hv);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HorizontalVpViewHolder {
        return HorizontalVpViewHolder(LayoutInflater.from(context).inflate((R.layout.viewpager_item), parent, false));
    }

    override fun getItemCount(): Int {
        return backgrounds?.size?:0
    }

    override fun onBindViewHolder(holder: HorizontalVpViewHolder, position: Int) {
        holder?.apply {
            mTextView.setText("第  " + (position + 1) + " 界面");
            mLinearLayout.setBackgroundResource(backgrounds.get(position));
        }
    }
}