package com.epoxy.playground.entity

data class TransactionHistoryEntity(
    val title : String,
    val amount : String,
    val dateTime : String,
    val imageUrl : String,
    val trxId : String,
    val transactionType : TransactionType
)

enum class TransactionType{
    DEBIT,
    CREDIT
}
