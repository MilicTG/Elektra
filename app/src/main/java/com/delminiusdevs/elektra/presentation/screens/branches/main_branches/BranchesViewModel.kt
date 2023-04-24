package com.delminiusdevs.elektra.presentation.screens.branches.main_branches

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BranchesViewModel @Inject constructor(

) : ViewModel() {

    var state by mutableStateOf(BranchesState())
        private set
}