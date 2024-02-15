package com.epoxy.playground.demodata

import com.epoxy.playground.entity.CardItemEntity
import com.epoxy.playground.epoxymodel.CardItemModel

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
}

enum class CardType{
    Balance,
    Loan
}