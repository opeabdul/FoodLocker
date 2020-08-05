package com.example.fudlocker

import androidx.databinding.BindingAdapter
import androidx.paging.PagedList
import androidx.recyclerview.widget.RecyclerView
import com.example.fudlocker.model.Product
import com.example.fudlocker.ui.main.adapters.ProductAdapter


@BindingAdapter("listData")
fun bindRecyclerView(recyclerView: RecyclerView, data: PagedList<Product>?) {
    val adapter = recyclerView.adapter as ProductAdapter
    adapter.submitList(data) {
        // scroll the list to the top after the diffs are calculated and posted
        recyclerView.scrollToPosition(0)
    }
}