package com.delminiusdevs.elektra.presentation.screens.branches.add_branches

import com.delminiusdevs.elektra.domain.model.BranchOffice

data class AddBranchesState(
    val branches: List<BranchOffice> = emptyList(),
    val isLoading: Boolean = true,
    val isError: Boolean = false,
    val errorMessage: String = "",
)
