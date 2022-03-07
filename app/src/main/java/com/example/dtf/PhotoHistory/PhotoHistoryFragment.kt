package com.example.dtf.PhotoHistory

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.dtf.R
import com.example.dtf.databinding.FragmentPhotoHistoryBinding


class PhotoHistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentPhotoHistoryBinding>(
            inflater,
            R.layout.fragment_photo_history,
            container,
            false
        )

        return binding.root
    }

}