package com.delminiusdevs.elektra.presentation.screens.branches.add_branches

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.delminiusdevs.elektra.domain.model.BranchOffice
import com.delminiusdevs.elektra.domain.use_cases.branches_use_cases.BranchesUseCases
import com.delminiusdevs.elektra.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddBranchesViewModel @Inject constructor(
    private val branchesUseCases: BranchesUseCases,
) : ViewModel() {

    var state by mutableStateOf(AddBranchesState())
        private set

    init {
        getAllBranches()
    }

    fun onEvent(event: AddBranchEvent) {
        when (event) {
            is AddBranchEvent.OnSubscribeToBranch -> {
                subscribeToBranchOffice(branchOffice = event.branchOffice)
            }
        }
    }

    private fun getAllBranches() {
        viewModelScope.launch {
            branchesUseCases.getAllBranchOfficesUseCase().collect { response ->
                when (response) {
                    is Resource.Error -> {
                        state = state.copy(
                            isError = true,
                            errorMessage = response.message.toString()
                        )
                    }

                    is Resource.Loading -> {
                        state = state.copy(
                            isLoading = response.isLoading
                        )
                    }

                    is Resource.Success -> {
                        response.data?.let {
                            state = state.copy(
                                branches = it
                            )
                        }
                    }
                }
            }
        }
    }

    private fun subscribeToBranchOffice(branchOffice: BranchOffice) {
        viewModelScope.launch {
            branchesUseCases.subscribeToBranchOfficeUseCase(branchOffice = branchOffice)
        }
    }

}