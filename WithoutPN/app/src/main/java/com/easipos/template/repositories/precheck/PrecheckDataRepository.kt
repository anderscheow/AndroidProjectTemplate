package com.easipos.template.repositories.precheck

import com.easipos.template.api.requests.precheck.CheckVersionRequestModel
import com.easipos.template.datasource.DataFactory
import com.easipos.template.models.Result

class PrecheckDataRepository(private val dataFactory: DataFactory) : PrecheckRepository {

    override suspend fun checkVersion(model: CheckVersionRequestModel): Result<Boolean> =
        dataFactory.createPrecheckDataSource()
            .checkVersion(model)
}
