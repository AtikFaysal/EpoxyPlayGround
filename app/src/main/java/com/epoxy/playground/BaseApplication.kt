package com.epoxy.playground

import android.app.Application
import com.epoxy.playground.customview.FontsOverride
import timber.log.Timber


class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        FontsOverride.setDefaultFont(this, "MONOSPACE", FontsOverride.regularFont)
    }
}