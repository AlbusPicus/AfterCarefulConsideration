package com.albuspicus.acc.bingo.ui.companieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.albuspicus.acc.data.Company
import com.albuspicus.acc.usecase_random_companies.GetRandomCompaniesUseCase

class CompaniesListViewModel(
    private val getRandomCompaniesUseCase: GetRandomCompaniesUseCase
) : ViewModel() {

    val companiesList: LiveData<List<Company>> = liveData {
        val data = getRandomCompaniesUseCase.getRandomCompanies(numberOfCompanies = 6)
        emit(data)
    }

}