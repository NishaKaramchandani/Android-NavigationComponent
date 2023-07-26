package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.navGraphViewModels
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.databinding.FragmentConfirmationBinding
import com.example.navigationcomponentexample.databinding.FragmentSpecifyAmountBinding
import com.example.navigationcomponentexample.viewmodel.MainViewModel

class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding

    private val viewModel: MainViewModel by activityViewModels<MainViewModel>()

    companion object {
        private const val TAG = "ConfirmationFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentConfirmationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val transaction = arguments?.let { ConfirmationFragmentArgs.fromBundle(it).transaction }

        if (transaction != null) {
            viewModel.addTransaction(transaction)

            Log.d(TAG, "onViewCreated: ${viewModel.transactionList.value}")

            val message = "Transferred $ ${transaction.amount} to ${transaction.name}"
            binding.confirmationMessage.text = message
        }
    }
}