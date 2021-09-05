package com.example.hammerhead.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.hammerhead.databinding.CategoriesItemBinding

class AppBarCategoriesAdapter(private val listOfCategories:List<String>):
    RecyclerView.Adapter<AppBarCategoriesAdapter.ViewHolder>() {
    var selectedPos=0
    inner class ViewHolder(private val binding: CategoriesItemBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(category: String){
            binding.category.text=category
            if(bindingAdapterPosition==selectedPos) {
                binding.category.isSelected = true
                binding.category.elevation= 0F
            }else{
                binding.category.isSelected = false
                binding.category.elevation= 2F
            }
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
        holder.bind(listOfCategories[position])
    }

    override fun getItemCount() = listOfCategories.size
}