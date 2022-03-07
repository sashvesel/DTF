package com.example.dtf.FaceTouchesToday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.dtf.R
import com.example.dtf.databinding.FragmentTodayBinding


class TodayFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentTodayBinding>(
            inflater,
            R.layout.fragment_today,
            container,
            false
        )

        return binding.root
    }

}