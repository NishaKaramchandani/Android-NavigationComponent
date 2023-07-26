package com.example.navigationcomponentexample.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.navigationcomponentexample.R
import com.example.navigationcomponentexample.databinding.FragmentMainBinding
import com.example.navigationcomponentexample.utils.safeNavigate
import dagger.hilt.android.AndroidEntryPoint

class MainFragment : Fragment(), View.OnClickListener {

    private lateinit var binding: FragmentMainBinding

    companion object {
        private const val TAG = "MainFragment"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.viewTransactionsBtn.setOnClickListener(this)
        binding.sendMoneyBtn.setOnClickListener(this)
        binding.viewBalanceBtn.setOnClickListener(this)


    }

    override fun onClick(view: View?) {
        if (view != null) {
            when (view.id) {
                R.id.view_transactions_btn -> findNavController().safeNavigate(
                    MainFragmentDirections.actionMainFragmentToViewTransactionFragment()
                )

                R.id.send_money_btn -> findNavController().safeNavigate(MainFragmentDirections.actionMainFragmentToChooseRecipientFragment())
                R.id.view_balance_btn -> findNavController().safeNavigate(MainFragmentDirections.actionMainFragmentToViewBalanceFragment())
            }
        }
    }
}