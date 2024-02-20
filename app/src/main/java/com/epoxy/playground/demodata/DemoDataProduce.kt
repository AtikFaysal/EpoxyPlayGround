package com.epoxy.playground.demodata

import com.epoxy.playground.R
import com.epoxy.playground.entity.BillMenuEntity
import com.epoxy.playground.entity.CardItemEntity
import com.epoxy.playground.entity.TransactionHistoryEntity
import com.epoxy.playground.entity.TransactionType
import com.epoxy.playground.epoxymodel.CardItemModel
import java.util.UUID
import kotlin.random.Random

object DemoDataProduce {
    val cardItems = listOf(
        CardItemEntity(
            title = "Account balance",
            amount = "₦ 2,554,706",
            bankName = "City Bank",
            accountNo = "1521556456",
            cardType = CardType.Balance,
        ),
        CardItemEntity(
            title = "You owe",
            amount = "₦ 2,554",
            paymentDate = "12th Jan, 2024",
            cardType = CardType.Loan,
        )
    )

    val billMenuItems = listOf(
        BillMenuEntity(
            menuIcon = R.drawable.ic_mobile,
            menuName = "Airtime"
        ),BillMenuEntity(
            menuIcon = R.drawable.ic_wifi,
            menuName = "Internet"
        ),BillMenuEntity(
            menuIcon = R.drawable.ic_tv,
            menuName = "Cable Tv"
        ),BillMenuEntity(
            menuIcon = R.drawable.ic_electricity,
            menuName = "Electricity"
        )
    )

    fun getTransactionHistory() : List<TransactionHistoryEntity>{
        val items = mutableListOf<TransactionHistoryEntity>()
        for (i in 1..10){
            items.add(
                TransactionHistoryEntity(
                    trxId = UUID.randomUUID().toString(),
                    title = if(i % 2 == 0)  "Credit amount " else "Loan payment",
                    dateTime = "20th Jan, 2024, 04:55 PM",
                    amount = "₦ 1,800,400",
                    imageUrl = "https://as1.ftcdn.net/v2/jpg/05/59/06/26/1000_F_559062693_MwnyGqzAR2uSRDfG0hxUvb5fd7TB3puZ.jpg",
                    transactionType = if(i % 2 == 0) TransactionType.CREDIT else TransactionType.DEBIT
                )
            )
        }

        return items
    }
}

enum class CardType{
    Balance,
    Loan
}