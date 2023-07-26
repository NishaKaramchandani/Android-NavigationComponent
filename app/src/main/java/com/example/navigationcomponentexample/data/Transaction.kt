package com.example.navigationcomponentexample.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.math.BigDecimal

@Parcelize
data class Transaction(
    val id: Int,
    val name: String,
    val amount: BigDecimal
) : Parcelable
