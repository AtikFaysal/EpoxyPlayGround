package com.epoxy.playground.epoxymodel

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyButtonBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_button))
abstract class ButtonModel : ViewBindingEpoxyModelWithHolder<EpoxyButtonBinding>(){

    @EpoxyAttribute
    lateinit var buttonText : String

    @EpoxyAttribute
    lateinit var onClickListener : (View) -> Unit

    override fun EpoxyButtonBinding.bind() {
        appButton.text = buttonText
        appButton.setOnClickListener(onClickListener)
    }

    override fun EpoxyButtonBinding.unbind() {
        appButton.setOnClickListener(null)
    }
}