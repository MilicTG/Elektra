package com.delminiusdevs.elektra.data.repository

import com.delminiusdevs.elektra.data.local.ElectraDatabase
import com.delminiusdevs.elektra.data.mappers.toBranchOffice
import com.delminiusdevs.elektra.data.mappers.toBranchOfficeDto
import com.delminiusdevs.elektra.data.remote.ElectraApi
import com.delminiusdevs.elektra.domain.model.BranchOffice
import com.delminiusdevs.elektra.domain.repository.BranchesRepository
import com.delminiusdevs.elektra.util.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class BranchesRepositoryImpl @Inject constructor(
    private val electraApi: ElectraApi,
    private val electraDatabase: ElectraDatabase
) : BranchesRepository {

    private val branchOfficeDao = electraDatabase.branchOfficeDao

    override suspend fun getAllBranches(): Flow<Resource<List<BranchOffice>>> = flow {
        emit(Resource.Loading(isLoading = true))

        val response = try {
            electraApi.getAllBranchOffices()
        } catch (e: HttpException) {
            emit(Resource.Error(message = e.localizedMessage ?: "Dogodila je se greška!"))
            null
        } catch (e: IOException) {
            emit(Resource.Error(message = "Dogodila je se greška u preuzimanju, molimo provjerite internet konekciju!"))
            null
        }

        response?.let { branch ->
            val parse = branch.map {
                it.toBranchOffice()
            }
            emit(
                Resource.Success(
                    data = parse
                )
            )
            emit(Resource.Loading(isLoading = false))
        }
    }

    override suspend fun subscribeToBranchOffice(branchOffice: BranchOffice) {
        branchOfficeDao.insertBranchOfficeInDatabase(branchOffice = branchOffice.toBranchOfficeDto())
    }

    override suspend fun getAllSubscribedBranches() = branchOfficeDao.getAllSavedBranchOffices()
}