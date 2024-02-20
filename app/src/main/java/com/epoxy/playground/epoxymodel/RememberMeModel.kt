package com.epoxy.playground.epoxymodel

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyRememberMeBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_remember_me))
abstract class RememberMeModel : ViewBindingEpoxyModelWithHolder<EpoxyRememberMeBinding>(){
    @EpoxyAttribute
    lateinit var onCheckedChange : (Boolean) -> Unit

    @EpoxyAttribute
    lateinit var onButtonClick : (View) -> Unit

    override fun EpoxyRememberMeBinding.bind() {
        checkboxCb.setOnCheckedChangeListener { _, isChecked ->
            onCheckedChange.invoke(isChecked)
        }

        forgotPasswordBtn.setOnClickListener(onButtonClick)
    }
}