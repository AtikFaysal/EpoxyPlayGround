package com.epoxy.playground.utils

import android.widget.ImageView
import coil.load
import coil.transform.CircleCropTransformation
import com.epoxy.playground.R

fun ImageView.loadImage(url : String, placeholder : Int = R.drawable.image_placeholder){
    this.load(url) {
        crossfade(true)
        placeholder(placeholder)
    }
}