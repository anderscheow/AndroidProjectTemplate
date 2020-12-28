package com.easipos.template.datasource.precheck

import com.easipos.template.api.requests.precheck.CheckVersionRequestModel
import com.easipos.template.models.Result

interface PrecheckDataStore {

    suspend fun checkVersion(model: CheckVersionRequestModel): Result<Boolean>
}
