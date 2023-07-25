package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationcomponentexample.databinding.FragmentSpecifyAmountBinding
import com.example.navigationcomponentexample.databinding.FragmentViewBalanceBinding

class ViewBalanceFragment : Fragment() {

    private lateinit var binding: FragmentViewBalanceBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewBalanceBinding.inflate(inflater, container, false)
        return binding.root
    }
}