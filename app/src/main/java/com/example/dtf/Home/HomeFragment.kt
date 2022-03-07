package com.example.dtf.Home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.dtf.R
import com.example.dtf.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        binding.cvTodayFragment.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_todayFragment)
        }

        binding.cvPhotoHistoryFragment.setOnClickListener { view: View ->
            view.findNavController().navigate(R.id.action_homeFragment_to_photoHistoryFragment)
        }

        return  binding.root
    }

}