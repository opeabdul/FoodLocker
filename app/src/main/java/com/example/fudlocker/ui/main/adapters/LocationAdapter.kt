package com.example.fudlocker.ui.main.adapters


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fudlocker.databinding.ItemLocationBinding
import com.example.fudlocker.model.Location

class LocationAdapter(): ListAdapter<Location, LocationAdapter.LocationViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationViewHolder {
        return LocationViewHolder(ItemLocationBinding.inflate(LayoutInflater.from(parent.context),
            parent, false))
    }

    override fun onBindViewHolder(holder: LocationViewHolder, position: Int) {
        val item = getItem(position)
        item.id = position + 1
        holder.bind(item)
    }

    inner class LocationViewHolder(val binding: ItemLocationBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(item: Location){
            binding.location = item
            binding.executePendingBindings()
        }

        fun from(){

        }
    }

    class DiffCallBack(): DiffUtil.ItemCallback<Location>(){
        override fun areItemsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Location, newItem: Location): Boolean {
            return oldItem == newItem
        }

    }

}

