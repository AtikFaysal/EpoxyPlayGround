package com.epoxy.playground.epoxymodel

import androidx.annotation.DrawableRes
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyBillTypeItemBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_bill_type_item))
abstract class BillTypeItemModel : ViewBindingEpoxyModelWithHolder<EpoxyBillTypeItemBinding>(){

    @DrawableRes
    @EpoxyAttribute var menuIcon : Int = R.drawable.ic_mobile
    @EpoxyAttribute lateinit var menuName : String

    override fun EpoxyBillTypeItemBinding.bind() {
        menuIconIv.setImageResource(menuIcon)
        menuNameTv.text = menuName
    }
}