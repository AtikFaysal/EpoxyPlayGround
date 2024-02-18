package com.epoxy.playground.epoxymodel

import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyRecentTransactionHeadingBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_recent_transaction_heading))
abstract class RecentTransactionHeadingModel : ViewBindingEpoxyModelWithHolder<EpoxyRecentTransactionHeadingBinding>(){
    override fun EpoxyRecentTransactionHeadingBinding.bind() {}
}