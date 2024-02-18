package com.epoxy.playground.demodata

import com.epoxy.playground.R
import com.epoxy.playground.entity.BillMenuEntity
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
}

enum class CardType{
    Balance,
    Loan
}