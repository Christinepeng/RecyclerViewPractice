package com.example.recyclerviewpractice.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerviewpractice.R
import com.example.recyclerviewpractice.data.Snoopy

class MyAdapter(private val onClick: (Snoopy) -> Unit) :
    ListAdapter<Snoopy, MyAdapter.ViewHolder>(SnoopyDiffCallback)  {
    class ViewHolder(itemView: View, val onClick: (Snoopy) -> Unit): RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.image)
        val textView: TextView = itemView.findViewById(R.id.name)
        var currentSnoopy: Snoopy? = null

        init {
            itemView.setOnClickListener {
                currentSnoopy?.let {
                    onClick(it)
                }
            }
        }

        fun bind(snoopy: Snoopy) {
            currentSnoopy = snoopy

            textView.text = snoopy.name
            if (snoopy.image != null) {
                imageView.setImageResource(snoopy.image)
            } else {
                imageView.setImageResource(R.drawable.woodstock)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ViewHolder(view, onClick)
    }

//    override fun getItemCount(): Int {
//        return snoopyList.size
//    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val snoopy = getItem(position)
        holder.imageView.setImageResource(snoopy.image)
        holder.textView.text = snoopy.name
        holder.bind(snoopy)
    }
}

object SnoopyDiffCallback : DiffUtil.ItemCallback<Snoopy>() {
    override fun areItemsTheSame(oldItem: Snoopy, newItem: Snoopy): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Snoopy, newItem: Snoopy): Boolean {
        return oldItem.id == newItem.id
    }
}