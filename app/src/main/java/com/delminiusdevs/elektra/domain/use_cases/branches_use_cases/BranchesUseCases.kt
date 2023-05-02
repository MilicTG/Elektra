package com.delminiusdevs.elektra.domain.use_cases.branches_use_cases

data class BranchesUseCases(
    val getAllBranchOfficesUseCase: GetAllBranchOfficesUseCase,
    val subscribeToBranchOfficeUseCase: SubscribeToBranchOfficeUseCase,
    val getAllSubscribedBranchesUseCase: GetAllSubscribedBranchesUseCase
)
