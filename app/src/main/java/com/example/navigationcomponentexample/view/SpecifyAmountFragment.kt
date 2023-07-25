package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.data.Money
import com.example.navigationcomponentexample.databinding.FragmentSpecifyAmountBinding
import com.example.navigationcomponentexample.utils.safeNavigate
import java.math.BigDecimal

class SpecifyAmountFragment : Fragment(), OnClickListener {

    private lateinit var binding: FragmentSpecifyAmountBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSpecifyAmountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sendBtn.setOnClickListener(this)
        binding.cancelBtn.setOnClickListener(this)

        arguments?.let { SpecifyAmountFragmentArgs.fromBundle(it).recipient }
    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.send_btn -> {
                    if (binding.inputAmount.text.isNullOrBlank()) {
                        Toast.makeText(context, "Please enter amount", Toast.LENGTH_SHORT).show()
                    } else {
                        val name = arguments?.let { SpecifyAmountFragmentArgs.fromBundle(it).recipient }
                        findNavController().safeNavigate(SpecifyAmountFragmentDirections.actionSpecifyAmountFragmentToConfirmationFragment(
                            Money(BigDecimal(binding.inputAmount.text.toString())), name!!
                        ))
                    }

                }

                R.id.cancel_btn -> activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }
}