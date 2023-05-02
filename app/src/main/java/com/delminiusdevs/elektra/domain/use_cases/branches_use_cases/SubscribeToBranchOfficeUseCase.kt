package com.delminiusdevs.elektra.domain.use_cases.branches_use_cases

import com.delminiusdevs.elektra.domain.model.BranchOffice
import com.delminiusdevs.elektra.domain.repository.BranchesRepository

class SubscribeToBranchOfficeUseCase(
    private val branchesRepository: BranchesRepository
) {
    suspend operator fun invoke(branchOffice: BranchOffice) =
        branchesRepository.subscribeToBranchOffice(branchOffice = branchOffice)
}