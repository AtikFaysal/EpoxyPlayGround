package com.epoxy.playground.epoxymodel

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyAppTopBarBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_app_top_bar))
abstract class AppTopBarModel : ViewBindingEpoxyModelWithHolder<EpoxyAppTopBarBinding>(){

    @EpoxyAttribute lateinit var greeting : String
    @EpoxyAttribute lateinit var onClickListener : (View) -> Unit

    override fun EpoxyAppTopBarBinding.bind() {
        greetingsTv.text = greeting
        addMoneyTv.setOnClickListener(onClickListener)
    }

    override fun EpoxyAppTopBarBinding.unbind() {
        addMoneyTv.setOnClickListener(null)
    }
}