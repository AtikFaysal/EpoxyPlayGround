package com.epoxy.playground.epoxymodel

import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyDateItemBinding
import com.epoxy.playground.utils.ViewBindingKotlinModel

data class DateItemModel(
    val date : String
) : ViewBindingKotlinModel<EpoxyDateItemBinding>(R.layout.epoxy_date_item){
    override fun EpoxyDateItemBinding.bind() {
        dateTv.text = date
    }
}