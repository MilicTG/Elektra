package com.delminiusdevs.elektra.presentation.screens.branches.main_branches

import com.delminiusdevs.elektra.domain.model.BranchOffice

data class BranchesState(
    val savedBranches: List<BranchOffice> = emptyList(),
)
