package com.delminiusdevs.elektra.data.remote

import com.delminiusdevs.elektra.data.model.BranchOfficeDto
import com.delminiusdevs.elektra.data.model.OutagesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ElectraApi {
    @GET(value = "/api/branchoffice")
    suspend fun getAllBranchOffices(): List<BranchOfficeDto>

    @GET(value = "/api/powercut/date/{powerCutDate}/branchoffice/0")
    suspend fun getPowerCutDataForSpecificDate(
        @Path(value = "powerCutDate") date: String
    ): List<OutagesDto>
}