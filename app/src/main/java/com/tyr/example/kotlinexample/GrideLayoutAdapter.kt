package com.tyr.example.kotlinexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class GrideLayoutAdapter(mContext:Context?): RecyclerView.Adapter<GrideLayoutAdapter.GridViewHolder>() {

    val tools:ArrayList<Tool> by lazy {
        ArrayList<Tool>()
    }


    var context:Context? = mContext
    init {

        tools.let {
            it.add(Tool("Calculator",android.R.color.holo_blue_bright, ToolActivityEnum.Calculator))
            it.add(Tool("Archive",android.R.color.holo_red_dark, ToolActivityEnum.Archive))

        }
    }

    private var mOnItemClickListener: OnItemClickListener? = null

    class GridViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cardView: CardView = itemView.findViewById(R.id.cardview);
        var textView: TextView =  itemView.findViewById(R.id.cardview_info);

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GridViewHolder {
        return GridViewHolder(LayoutInflater.from(context).inflate((R.layout.fragment_card), parent, false));
    }

    override fun getItemCount(): Int {
        return tools.size
    }

    override fun onBindViewHolder(holder: GridViewHolder, position: Int) {

        if (mOnItemClickListener != null) {
            holder.itemView.setOnClickListener {
                mOnItemClickListener?.apply { onItemClick(holder.itemView,position, tools.get(position)) }
            }

            holder.itemView.setOnLongClickListener{
                var result: Boolean? = mOnItemClickListener?.onItemLongClick(holder.itemView,position, tools.get(position))
                result?:false
            }


        }

        holder.apply {
            cardView.setBackgroundResource(tools.get(position).color);
            textView.setText(tools.get(position).name)
        }
    }


    fun setOnItemClickListener(onItemClickListener: OnItemClickListener) {
        this.mOnItemClickListener = onItemClickListener
    }

}