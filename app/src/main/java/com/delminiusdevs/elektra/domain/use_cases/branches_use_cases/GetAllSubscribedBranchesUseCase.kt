package com.delminiusdevs.elektra.domain.use_cases.branches_use_cases

import com.delminiusdevs.elektra.domain.repository.BranchesRepository

class GetAllSubscribedBranchesUseCase(
    private val branchesRepository: BranchesRepository
) {
    suspend operator fun invoke() =
        branchesRepository.getAllSubscribedBranches()
}