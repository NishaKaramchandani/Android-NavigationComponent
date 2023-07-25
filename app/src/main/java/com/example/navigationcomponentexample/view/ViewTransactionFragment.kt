package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationcomponentexample.databinding.FragmentViewTransactionBinding

class ViewTransactionFragment : Fragment() {

    private lateinit var binding: FragmentViewTransactionBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }
}