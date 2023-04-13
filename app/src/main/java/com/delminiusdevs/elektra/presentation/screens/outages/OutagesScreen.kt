package com.delminiusdevs.elektra.presentation.screens.outages

import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminiusdevs.elektra.presentation.composables.appbar.OutagesAppbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutagesScreen(
    viewModel: OutagesViewModel = hiltViewModel()
) {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val state = viewModel.state

    Scaffold(
        topBar = {
            OutagesAppbar(
                title = "Najavljeni nestanci",
                scrollBehavior = scrollBehavior,
                onInfoClicked = {

                },
                onRefreshClicked = {

                },
                onSettingsClicked = {

                }
            )
        },
    ) {

        when {
            state.isLoading -> {
                Text(text = "Loading")
            }

            state.isError -> {
                Text(text = state.errorMessage)
            }

            else -> {
                Text(text = state.firstDayOutages.toString())

            }
        }
    }
}