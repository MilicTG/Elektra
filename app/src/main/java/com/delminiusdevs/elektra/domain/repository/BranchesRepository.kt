package com.delminiusdevs.elektra.domain.repository

import com.delminiusdevs.elektra.domain.model.BranchOffice
import com.delminiusdevs.elektra.util.Resource
import kotlinx.coroutines.flow.Flow

interface BranchesRepository {

    suspend fun getAllBranches(): Flow<Resource<List<BranchOffice>>>

    suspend fun subscribeToBranchOffice(branchOffice: BranchOffice)

    suspend fun getAllSubscribedBranches(): List<BranchOffice>
}