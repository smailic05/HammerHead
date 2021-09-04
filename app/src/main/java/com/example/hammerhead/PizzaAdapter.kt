package com.example.hammerhead

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.hammerhead.databinding.PizzaViewBinding

class PizzaAdapter : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {
    inner class ViewHolder(private val binding: PizzaViewBinding):
        RecyclerView.ViewHolder(binding.root) {
        fun bind(){
            binding.imagePizza.setImageResource(R.drawable.buffalo)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PizzaViewBinding.inflate(layoutInflater,parent,false)
        return  ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind()
    }

    override fun getItemCount() = 100

}
