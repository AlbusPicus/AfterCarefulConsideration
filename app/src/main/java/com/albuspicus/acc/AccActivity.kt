package com.albuspicus.acc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.albuspicus.acc.bingo.ui.companieslist.CompaniesListFragment
import org.kodein.di.DIAware
import org.kodein.di.DIContext
import org.kodein.di.android.subDI
import org.kodein.di.bindings.Strong
import org.kodein.di.diContext

class AccActivity : AppCompatActivity(), DIAware {

    override val diContext: DIContext<*> = diContext(Strong) { this }

    override val di by subDI({ (application as DIAware).di }) {
        //nothing
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CompaniesListFragment.newInstance())
                .commitNow()
        }
    }
}