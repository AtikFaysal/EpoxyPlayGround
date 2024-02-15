package com.epoxy.playground.entity

import com.epoxy.playground.demodata.CardType

data class CardItemEntity(
    val title : String,
    val amount : String,
    val bankName : String = "",
    val accountNo : String = "",
    val paymentDate : String = "",
    var cardType : CardType
)
