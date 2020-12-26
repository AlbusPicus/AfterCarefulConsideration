package com.albuspicus.acc.bingo.ui.bingo

import com.albuspicus.acc.usecase_random_companies.GetRandomCompaniesUseCase
import com.albuspicus.acc.usecase_random_companies.GetStubRandomCompaniesUseCase
import com.albuspicus.ui.obtainRegisteredViewModel
import org.kodein.di.DI
import org.kodein.di.bind
import org.kodein.di.instance
import org.kodein.di.provider


fun BingoFragment.module() = DI.Module("BingoFragmentModule") {

    bind<GetRandomCompaniesUseCase>() with instance(GetStubRandomCompaniesUseCase())
    bind<BingoViewModel>() with provider {
        obtainRegisteredViewModel { BingoViewModel() }
    }

}
