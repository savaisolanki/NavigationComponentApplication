package com.example.navigationcomponentapplication.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.navigationcomponentapplication.R
import com.example.navigationcomponentapplication.databinding.FragmentMiddleBinding

class MiddleFragment : Fragment() {

    private lateinit var binding: FragmentMiddleBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_middle, container, false)
        return binding.root
    }


}