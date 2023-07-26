package com.example.navigationcomponentexample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.navigationcomponentexample.data.Transaction
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(): ViewModel() {

    private var _transactionList = MutableLiveData<List<Transaction>>()

    val transactionList: LiveData<List<Transaction>> = _transactionList

    private var _id = 0

    companion object {
        private const val TAG = "MainViewModel"
    }

    fun addTransaction(transaction: Transaction) {
        if (_transactionList.value == null)
            _transactionList.value = mutableListOf()
        val list = _transactionList.value!!.toMutableList()
        list.add(transaction)
        _transactionList.value = list

        Log.d(TAG, "onViewCreated: ${transactionList.value}")
    }

    fun generateTransactionId(): Int {
        _id = Random.nextInt(Integer.MAX_VALUE)
        Log.d(TAG, "generateTransactionId: $_id")
        return _id
    }
}