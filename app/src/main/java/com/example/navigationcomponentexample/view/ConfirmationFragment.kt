package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationcomponentexample.databinding.FragmentConfirmationBinding
import com.example.navigationcomponentexample.databinding.FragmentSpecifyAmountBinding

class ConfirmationFragment : Fragment() {

    private lateinit var binding: FragmentConfirmationBinding

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
        val name = arguments?.let { ConfirmationFragmentArgs.fromBundle(it).recipient }
        val amount = arguments?.let { ConfirmationFragmentArgs.fromBundle(it).amount }

        if (amount != null) {
            val message = "$ ${amount.amount} from $name"
            binding.confirmationMessage.text = message
        }
    }
}