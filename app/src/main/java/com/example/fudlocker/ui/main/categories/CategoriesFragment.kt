package com.example.fudlocker.ui.main.categories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fudlocker.R
import com.example.fudlocker.databinding.FragmentCategoriesBinding
import com.example.fudlocker.databinding.FragmentProductsBinding
import com.example.fudlocker.ui.main.adapters.CategoriesAdapter
import com.example.fudlocker.ui.main.adapters.ProductAdapter

/**
 * A placeholder fragment containing a simple view.
 */
class CategoriesFragment : Fragment() {

    private lateinit var categoriesViewModel: CategoriesViewModel
    private lateinit var mBinding: FragmentCategoriesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        categoriesViewModel = ViewModelProviders.of(this).get(CategoriesViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentCategoriesBinding.inflate(inflater, container, false)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = categoriesViewModel
        mBinding.categoriesList.layoutManager = GridLayoutManager(requireContext(), 2,
            LinearLayoutManager.VERTICAL, false)
        mBinding.categoriesList.adapter = CategoriesAdapter()
        return mBinding.root
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(sectionNumber: Int): CategoriesFragment {
            return CategoriesFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}