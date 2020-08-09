package com.example.fudlocker.ui.main.locations

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
import com.example.fudlocker.databinding.FragmentLocationsBinding
import com.example.fudlocker.ui.main.adapters.LocationAdapter

/**
 * A placeholder fragment containing a simple view.
 */
class LocationsFragment : Fragment() {

    private lateinit var locationsViewModel: LocationsViewModel
    private lateinit var mBinding: FragmentLocationsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        locationsViewModel = ViewModelProviders.of(this).get(LocationsViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
    }

    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentLocationsBinding.inflate(inflater, container, false)
        mBinding.lifecycleOwner = this
        mBinding.viewModel = locationsViewModel
        mBinding.locationList.layoutManager = GridLayoutManager(requireContext(), 3,
            LinearLayoutManager.VERTICAL, false)
        mBinding.locationList.adapter = LocationAdapter()
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
        fun newInstance(sectionNumber: Int): LocationsFragment {
            return LocationsFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
            }
        }
    }
}