package com.example.fudlocker.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fudlocker.databinding.ItemCategoryBinding
import com.example.fudlocker.model.Category

class CategoriesAdapter: ListAdapter<Category, CategoriesAdapter.CategoryViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            ItemCategoryBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    inner class CategoryViewHolder(val mBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(category: Category) {
            mBinding.category = category
            mBinding.executePendingBindings()
        }
    }

    class DiffCallBack() : DiffUtil.ItemCallback<Category>() {
        override fun areItemsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Category, newItem: Category): Boolean {
            return oldItem == newItem
        }

    }

}