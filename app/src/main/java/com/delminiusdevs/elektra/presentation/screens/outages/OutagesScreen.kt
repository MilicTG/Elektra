package com.delminiusdevs.elektra.presentation.screens.outages

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminiusdevs.elektra.presentation.composables.appbar.OutagesAppbar
import com.delminiusdevs.elektra.presentation.composables.cards.OutagesCard
import com.delminiusdevs.elektra.presentation.composables.containers.LoadingContainer
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutagesScreen(
    viewModel: OutagesViewModel = hiltViewModel(),
) {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val state = viewModel.state

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            OutagesAppbar(
                title = "Najavljeni nestanci",
                scrollBehavior = scrollBehavior,
                onInfoClicked = {

                },
                onRefreshClicked = {
                    viewModel.onEvent(OutagesEvent.OnRefreshTap)
                },
                onSettingsClicked = {

                }
            )
        },
    ) { paddingValues ->

        when {
            state.isLoading -> {
                LoadingContainer(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            start = NORMAL_PADDING,
                            end = NORMAL_PADDING
                        ),
                    title = "Učitavanje..."
                )
            }

            state.isError -> {
                Text(text = state.errorMessage)
            }

            state.outagesComplete.isEmpty() -> {
                Text(text = "Prazno")
            }

            else -> {

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(
                            top = paddingValues.calculateTopPadding(),
                            start = NORMAL_PADDING,
                            end = NORMAL_PADDING
                        )
                ) {
                    items(count = state.outagesComplete.size) { index ->
                        OutagesCard(
                            outages = state.outagesComplete[index]
                        )
                    }
                }
            }
        }
    }
}