package com.epoxy.playground.epoxymodel

import androidx.core.view.isVisible
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyCardItemBinding
import com.epoxy.playground.demodata.CardType
import com.epoxy.playground.entity.CardItemEntity
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_card_item))
abstract class CardItemModel(
) : ViewBindingEpoxyModelWithHolder<EpoxyCardItemBinding>(){

    @EpoxyAttribute lateinit var entity: CardItemEntity

    override fun EpoxyCardItemBinding.bind() {
        titleTv.text = entity.title
        amountTv.text = entity.amount
        bankNameTv.text = entity.bankName
        accountNoTv.text = entity.accountNo
        paymentDateTv.text = entity.paymentDate

        paymentDateTv.isVisible = entity.cardType == CardType.Loan
        bankInfoLn.isVisible = entity.cardType == CardType.Balance
    }

    override fun EpoxyCardItemBinding.unbind() {
    }
}