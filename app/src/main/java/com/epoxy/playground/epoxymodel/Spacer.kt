package com.epoxy.playground.epoxymodel

import android.content.Context
import android.util.AttributeSet
import android.view.View
import android.view.ViewGroup
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.epoxy.playground.utils.displayRatioValue

@ModelView(autoLayout = ModelView.Size.MANUAL)
class Spacer @JvmOverloads constructor(
    private val context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
):View(context,attrs,defStyle){
    init {
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.MarginLayoutParams.WRAP_CONTENT,
            ViewGroup.MarginLayoutParams.WRAP_CONTENT
        )
    }

    @ModelProp(group = "view_spacer_model")
    fun setWidth(width:Int){
        layoutParams = ViewGroup.LayoutParams(
            context.displayRatioValue(width),
            ViewGroup.MarginLayoutParams.WRAP_CONTENT
        )
        invalidate()
    }

    @ModelProp(group = "view_spacer_model")
    fun setHeight(height:Int){
        layoutParams = ViewGroup.LayoutParams(
            ViewGroup.MarginLayoutParams.WRAP_CONTENT,
            context.displayRatioValue(height)
        )
        invalidate()
    }


}