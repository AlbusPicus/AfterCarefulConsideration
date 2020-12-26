package com.albuspicus.acc

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import org.kodein.di.DI
import org.kodein.di.DIAware
import org.kodein.di.android.x.androidXModule

class AccApplication : Application(), DIAware {

    override val di by DI.lazy {
        import(androidXModule(this@AccApplication))
    }

    override fun onCreate() {
        super.onCreate()
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
    }


}
