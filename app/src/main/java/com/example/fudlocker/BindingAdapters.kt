package com.example.fudlocker

import androidx.appcompat.widget.AppCompatImageView
import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fudlocker.model.Product
import com.example.fudlocker.ui.main.adapters.ProductAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: List<Any>?) {
    val adapter = recyclerView.adapter as ListAdapter<Any, RecyclerView.ViewHolder>
    adapter.submitList(data) {
        // scroll the list to the top after the diffs are calculated and posted
        recyclerView.scrollToPosition(0)
    }
}

@BindingAdapter("bindImage")
fun bindImageView(imageView: AppCompatImageView, imageSrc: String ){
    Glide.with(imageView.context).load(imageSrc).into(imageView)
}