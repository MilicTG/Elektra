package com.delminiusdevs.elektra.presentation.screens.branches.main_branches

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminiusdevs.elektra.domain.use_cases.branches_use_cases.BranchesUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel @Inject constructor(
    private val branchesUseCases: BranchesUseCases
) : ViewModel() {

    var state by mutableStateOf(BranchesState())
        private set

    fun onEvent(event: BranchesEvent) {
        when (event) {
            BranchesEvent.OnGetBranchOfficesFromDatabase -> {
                getAllBranchesFromDatabase()
            }
        }
    }

    private fun getAllBranchesFromDatabase() {
        viewModelScope.launch {
            val storedBranches = branchesUseCases.getAllSubscribedBranchesUseCase()

            state = state.copy(
                savedBranches = storedBranches
            )
        }
    }
}