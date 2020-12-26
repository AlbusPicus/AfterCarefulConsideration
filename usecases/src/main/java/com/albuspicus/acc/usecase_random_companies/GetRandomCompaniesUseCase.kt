package com.albuspicus.acc.usecase_random_companies

import com.albuspicus.acc.data.Company
import com.albuspicus.acc.repository.CompanyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

abstract class GetRandomCompaniesUseCase(private val repository: CompanyRepository) {

    suspend fun getRandomCompanies(numberOfCompanies: Int): List<Company> {
        return withContext(Dispatchers.Default) {
            val shuffledCompanies = repository.getCompanies().shuffled()
            if (numberOfCompanies > shuffledCompanies.size) {
                shuffledCompanies
            } else {
                shuffledCompanies.take(numberOfCompanies)
            }
        }
    }

}
