package com.albuspicus.acc.bingo.ui.companieslist

import com.albuspicus.acc.usecase_random_companies.GetRandomCompaniesUseCase
import com.albuspicus.acc.usecase_random_companies.GetStubRandomCompaniesUseCase
import com.albuspicus.acc.ui.obtainRegisteredViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider

fun CompaniesListFragment.module() = DI.Module("CompaniesListFragmentModule") {

    bind<GetRandomCompaniesUseCase>() with instance(GetStubRandomCompaniesUseCase())
    bind<CompaniesListViewModel>() with provider {
        obtainRegisteredViewModel { CompaniesListViewModel(instance()) }
    }

}
