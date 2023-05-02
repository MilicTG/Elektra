package com.delminiusdevs.elektra.presentation.screens.branches.main_branches

sealed class BranchesEvent {
    object OnGetBranchOfficesFromDatabase : BranchesEvent()
}
