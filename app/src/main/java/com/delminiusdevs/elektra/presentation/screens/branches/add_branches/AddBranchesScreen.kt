package com.delminiusdevs.elektra.presentation.screens.branches.add_branches

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminiusdevs.elektra.presentation.composables.appbar.NavigationAppbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBranchesScreen(
    navigateBack: () -> Unit,
    viewModel: AddBranchesViewModel = hiltViewModel(),
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val state = viewModel.state

    Scaffold(
        topBar = {
            NavigationAppbar(
                title = "Dodaj poslovnicu",
                scrollBehavior = scrollBehavior,
                onBackTaped = {
                    navigateBack()
                }
            )
        },
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding()),
        ) {
            when {
                state.isLoading -> Text(text = "Loading")
                state.isError -> Text(text = state.errorMessage)
                else -> Text(text = state.branches.toString())
            }
        }
    }
}