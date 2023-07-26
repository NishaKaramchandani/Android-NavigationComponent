package com.example.navigationcomponentexample.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.navigationcomponentexample.data.Transaction
import com.example.navigationcomponentexample.databinding.TransactionRowBinding

class TransactionAdapter(): RecyclerView.Adapter<TransactionViewHolder>() {

    private var transactionList: List<Transaction> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = TransactionRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    fun setTransactionList(list: List<Transaction>) {
        transactionList = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return transactionList.size
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = transactionList[position]
        holder.bind(item)
    }
}

class TransactionViewHolder(private val binding: TransactionRowBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(transaction: Transaction) {
        binding.name.text = transaction.name

        val amount = "$ ${transaction.amount}"
        binding.amount.text = amount
    }
}