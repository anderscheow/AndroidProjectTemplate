package com.easipos.template.datasource.precheck

import com.easipos.template.api.misc.parseException
import com.easipos.template.api.misc.parseResponse
import com.easipos.template.api.requests.precheck.CheckVersionRequestModel
import com.easipos.template.api.services.Api
import com.easipos.template.models.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PrecheckDataSource(private val api: Api) : PrecheckDataStore {

    override suspend fun checkVersion(model: CheckVersionRequestModel): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            try {
                val response = api.checkVersion(model.toFormDataBuilder().build())
                parseResponse(response) {
                    it
                }
            } catch (ex: Exception) {
                parseException(ex)
            }
        }
    }
}
