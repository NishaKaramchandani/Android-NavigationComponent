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
import com.example.navigationcomponentexample.databinding.FragmentChooseRecipientBinding
import com.example.navigationcomponentexample.databinding.FragmentSpecifyAmountBinding
import com.example.navigationcomponentexample.utils.safeNavigate

class ChooseRecipientFragment: Fragment(), OnClickListener {

    private lateinit var binding: FragmentChooseRecipientBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentChooseRecipientBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.nextBtn.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
        if (view != null) {
            when(view.id) {
                R.id.next_btn -> {
                    if (binding.inputRecipient.text.isNullOrBlank()) {
                        Toast.makeText(context, "Please enter a name", Toast.LENGTH_SHORT).show()
                    } else {
                        findNavController().safeNavigate(
                            ChooseRecipientFragmentDirections.actionChooseRecipientFragmentToSpecifyAmountFragment(
                                binding.inputRecipient.text.toString()
                            )
                        )
                    }
                }

                R.id.cancel_btn -> activity?.onBackPressedDispatcher?.onBackPressed()
            }
        }
    }
}