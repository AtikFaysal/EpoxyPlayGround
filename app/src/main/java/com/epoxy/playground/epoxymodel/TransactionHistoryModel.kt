package com.epoxy.playground.epoxymodel

import androidx.core.content.ContextCompat
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyTransactionHistoryItemBinding
import com.epoxy.playground.entity.TransactionHistoryEntity
import com.epoxy.playground.entity.TransactionType
import com.epoxy.playground.utils.ViewBindingKotlinModel
import com.epoxy.playground.utils.loadImage

data class TransactionHistoryModel(
    val trxHistory : TransactionHistoryEntity
) : ViewBindingKotlinModel<EpoxyTransactionHistoryItemBinding>(R.layout.epoxy_transaction_history_item ){

    override fun EpoxyTransactionHistoryItemBinding.bind() {
        titleTv.text = trxHistory.title
        timeTv.text = trxHistory.dateTime
        amountTv.text = trxHistory.amount

        imageIv.loadImage(trxHistory.imageUrl)

        if(trxHistory.transactionType == TransactionType.DEBIT)
            amountTv.setTextColor(ContextCompat.getColor(root.context, R.color.color_E0293B))
        else amountTv.setTextColor(ContextCompat.getColor(root.context, R.color.green_48A43F))
    }
}