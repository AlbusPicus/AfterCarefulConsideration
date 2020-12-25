package com.albuspicus.acc.repository

import com.albuspicus.acc.data.Company

interface CompanyRepository {

    suspend fun getCompanies(): List<Company>

}
