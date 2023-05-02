package com.delminiusdevs.elektra.presentation.screens.branches.add_branches

import com.delminiusdevs.elektra.domain.model.BranchOffice

sealed class AddBranchEvent {
    data class OnSubscribeToBranch(val branchOffice: BranchOffice) : AddBranchEvent()
}
