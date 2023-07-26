package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.navigation.navGraphViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.adapter.TransactionAdapter
import com.example.navigationcomponentexample.databinding.FragmentViewTransactionBinding
import com.example.navigationcomponentexample.viewmodel.MainViewModel

class ViewTransactionFragment : Fragment() {

    private lateinit var binding: FragmentViewTransactionBinding
    private lateinit var transactionAdapter: TransactionAdapter
    private val mainViewModel: MainViewModel by activityViewModels<MainViewModel>()

    companion object {
        private const val TAG = "ViewTransactionFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        transactionAdapter = TransactionAdapter()
        binding.transactionRecyclerview.apply {
            adapter = transactionAdapter
            layoutManager = LinearLayoutManager(context)
        }

        Log.d(TAG, "onViewCreated: ${mainViewModel.transactionList.value}")

        mainViewModel.transactionList.value?.let { transactionAdapter.setTransactionList(it) }


       mainViewModel.transactionList.observe(viewLifecycleOwner) {
            transactionAdapter.setTransactionList(it)
       }
    }
}