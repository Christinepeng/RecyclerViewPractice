package com.example.recyclerviewpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.data.Snoopy

class MyAdapter(private val snoopyList: List<Snoopy>): RecyclerView.Adapter<MyAdapter.ViewHolder>() {
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return snoopyList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val snoopy = snoopyList[position]
        holder.imageView.setImageResource(snoopy.image)
        holder.textView.text = snoopy.name
    }
}