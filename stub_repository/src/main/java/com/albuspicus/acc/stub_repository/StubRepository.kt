package com.albuspicus.acc.stub_repository

import com.albuspicus.acc.data.Company
import com.albuspicus.acc.repository.CompanyRepository

class StubCompanyRepository : CompanyRepository {

    override suspend fun getCompanies(): List<Company> {
        return listOf(
            Company("Rakuten"),
            Company("Google"),
            Company("PayPay"),
            Company("Mercari"),
            Company("SmartNews"),
            Company("LINE"),
            Company("Facebook"),
            Company("Apple"),
            Company("ExaWizards"),
            Company("Amazon"),
            Company("Netflix")
        )
    }

}
