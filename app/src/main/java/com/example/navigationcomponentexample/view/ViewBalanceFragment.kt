package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import com.example.navigationcomponentexample.databinding.FragmentSpecifyAmountBinding
import com.example.navigationcomponentexample.databinding.FragmentViewBalanceBinding
import com.example.navigationcomponentexample.viewmodel.MainViewModel
import java.math.BigDecimal

class ViewBalanceFragment : Fragment() {

    private lateinit var binding: FragmentViewBalanceBinding
    private val mainViewModel: MainViewModel by activityViewModels<MainViewModel>()

    companion object {
        private const val TAG = "ViewBalanceFragment"
    }
    
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentViewBalanceBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var balance = BigDecimal(0)
        mainViewModel.transactionList.value?.forEach { balance -= it.amount }
        Log.d(TAG, "onViewCreated: ${mainViewModel.transactionList.value}")
        val balanceStr = "$$balance in account"
        binding.balanceValue.text = balanceStr
    }
}