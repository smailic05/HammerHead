package com.example.hammerhead

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.hammerhead.databinding.ImageBinding

class AppBarImageAdapter: RecyclerView.Adapter<AppBarImageAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: ImageBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.imageView.setImageResource(R.drawable.banner)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ImageBinding.inflate(layoutInflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 3
}