package com.albuspicus.acc.usecase_random_companies

import com.albuspicus.acc.data.Company
import com.albuspicus.acc.repository.CompanyRepository

abstract class GetRandomCompaniesUseCase(private val repository: CompanyRepository) {

    suspend fun getRandomCompanies(numberOfCompanies: Int): List<Company> {
        val shuffledCompanies = repository.getCompanies().shuffled()
        return if (numberOfCompanies > shuffledCompanies.size) {
            shuffledCompanies
        } else {
            shuffledCompanies.take(numberOfCompanies)
        }
    }

}
