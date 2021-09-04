package com.example.hammerhead

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hammerhead.databinding.CategoriesItemBinding

class AppBarCategoriesAdapter: ListAdapter<String, AppBarCategoriesAdapter.ViewHolder>(itemComparator) {
    var selectedPos=0
    inner class ViewHolder(private val binding: CategoriesItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String){
            binding.category.text=category
            binding.category.isSelected = bindingAdapterPosition==selectedPos
            binding.category.setOnClickListener {
                notifyItemChanged(selectedPos)
                selectedPos=bindingAdapterPosition
                notifyItemChanged(selectedPos)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding= CategoriesItemBinding.inflate(layoutInflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    private companion object {
        private val itemComparator = object : DiffUtil.ItemCallback<String>() {

            override fun areItemsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: String, newItem: String): Boolean {
                return oldItem == newItem
            }

            override fun getChangePayload(oldItem: String, newItem: String) = Any()
        }
    }
}