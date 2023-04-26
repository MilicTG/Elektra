package com.delminiusdevs.elektra.data.repository

import com.delminiusdevs.elektra.data.mappers.toOutages
import com.delminiusdevs.elektra.data.remote.ElectraApi
import com.delminiusdevs.elektra.domain.model.Outages
import com.delminiusdevs.elektra.domain.repository.PowerOutagesRepository
import com.delminiusdevs.elektra.util.Resource
import com.delminiusdevs.elektra.util.getDateOrDayForSpecificDay
import com.delminiusdevs.elektra.util.getDayForSpecificDay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PowerOutagesRepositoryImpl @Inject constructor(
    private val electraApi: ElectraApi,
) : PowerOutagesRepository {

    override suspend fun getPowerCutDataForSpecificDate(
        date: String,
        dateCode: String,
    ): Flow<Resource<List<Outages>>> =
        flow {
            emit(Resource.Loading(isLoading = true))

            val response = try {
                electraApi.getPowerCutDataForSpecificDate(date = date)
            } catch (e: HttpException) {
                emit(Resource.Error(message = e.localizedMessage ?: "Dogodila je se greška!"))
                null
            } catch (e: IOException) {
                emit(Resource.Error(message = "Dogodila je se greška u preuzimanju, molimo provjerite internet konekciju!"))
                null
            }

            response?.let { outages ->
                val parse = outages.map {
                    it.toOutages(
                        dayDate = getDateOrDayForSpecificDay(day = dateCode),
                        dayName = getDayForSpecificDay(day = dateCode)
                    )
                }
                emit(
                    Resource.Success(
                        data = parse
                    )
                )
                emit(Resource.Loading(isLoading = false))
            }
        }
}

