package com.example.fudlocker.ui.main.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.fudlocker.databinding.ItemProductBinding
import com.example.fudlocker.model.Product

class ProductAdapter : ListAdapter<Product, ProductAdapter.ProductViewHolder>(DiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        return ProductViewHolder(
            ItemProductBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val item = getItem(position)
        item?.let {
            holder.bind(it)
        }
    }

    inner class ProductViewHolder(val mBinding: ItemProductBinding) :
        RecyclerView.ViewHolder(mBinding.root) {
        fun bind(product: Product) {
            mBinding.product = product
            mBinding.executePendingBindings()
        }
    }
}

class DiffCallBack() : DiffUtil.ItemCallback<Product>() {
    override fun areItemsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Product, newItem: Product): Boolean {
        return oldItem == newItem
    }

}