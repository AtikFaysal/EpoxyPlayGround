package com.epoxy.playground.epoxymodel

import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.widget.doAfterTextChanged
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyPasswordInputBinding
import com.epoxy.playground.databinding.EpoxyTextInputFieldBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_password_input))
abstract class PasswordInputFieldModel : ViewBindingEpoxyModelWithHolder<EpoxyPasswordInputBinding>(){
    @EpoxyAttribute
    lateinit var inputText : String

    @EpoxyAttribute
    @StringRes
    var hint : Int = R.string.hint_enter_password

    @EpoxyAttribute
    @StringRes
    var error : Int ?= null

    @EpoxyAttribute
    lateinit var onTextChange : (String) -> Unit

    override fun EpoxyPasswordInputBinding.bind() {
        passwordEt.hint = ContextCompat.getString(root.context, hint)
        passwordEt.setText(inputText)

        passwordEt.doAfterTextChanged {
            onTextChange.invoke(it.toString())
        }

        error?.let {
            errorTv.text = ContextCompat.getString(root.context, R.string.hint_enter_phone)
            errorTv.isVisible = true
        } ?: run {
            errorTv.isVisible = false
        }
    }
}