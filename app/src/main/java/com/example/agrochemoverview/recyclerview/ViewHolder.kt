package com.example.agrochemoverview.recyclerview

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.recycler_layout.view.*

class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    var nameText: TextView? = null
    var pathText: TextView? = null
    init{
        nameText = itemView.nameText
    }

}