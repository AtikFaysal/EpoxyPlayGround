package com.epoxy.playground.epoxymodel

import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.widget.doAfterTextChanged
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.epoxy.playground.R
import com.epoxy.playground.databinding.EpoxyTextInputFieldBinding
import com.epoxy.playground.utils.ViewBindingEpoxyModelWithHolder

@EpoxyModelClass(layout = (R.layout.epoxy_text_input_field))
abstract class TextInputModel : ViewBindingEpoxyModelWithHolder<EpoxyTextInputFieldBinding>(){
    @EpoxyAttribute
    lateinit var text : String

    @EpoxyAttribute
    @StringRes
    var hint : Int = R.string.hint_enter_phone

    @EpoxyAttribute
    @StringRes
    var error : Int ?= null

    @EpoxyAttribute
    lateinit var onTextChange : (String) -> Unit

    override fun EpoxyTextInputFieldBinding.bind() {
        textEt.hint = ContextCompat.getString(root.context, hint)
        textEt.setText(text)

        textEt.doAfterTextChanged {
            onTextChange.invoke(it.toString())
        }
    }
}