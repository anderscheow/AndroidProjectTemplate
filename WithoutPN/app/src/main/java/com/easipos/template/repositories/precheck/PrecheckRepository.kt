package com.easipos.template.repositories.precheck

import com.easipos.template.api.requests.precheck.CheckVersionRequestModel
import com.easipos.template.models.Result

interface PrecheckRepository {

    suspend fun checkVersion(model: CheckVersionRequestModel): Result<Boolean>
}
