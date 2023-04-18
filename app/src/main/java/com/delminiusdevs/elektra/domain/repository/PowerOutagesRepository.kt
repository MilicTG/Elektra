package com.delminiusdevs.elektra.domain.repository

import com.delminiusdevs.elektra.domain.model.Outages
import com.delminiusdevs.elektra.util.Resource
import kotlinx.coroutines.flow.Flow

interface PowerOutagesRepository {

    suspend fun getPowerCutDataForSpecificDate(
        date: String,  dateCode: String
    ): Flow<Resource<List<Outages>>>
}