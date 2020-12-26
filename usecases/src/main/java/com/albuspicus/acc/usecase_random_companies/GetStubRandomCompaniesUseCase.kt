package com.albuspicus.acc.usecase_random_companies

import com.albuspicus.acc.repository.stub.StubCompanyRepository

class GetStubRandomCompaniesUseCase : GetRandomCompaniesUseCase(StubCompanyRepository())
