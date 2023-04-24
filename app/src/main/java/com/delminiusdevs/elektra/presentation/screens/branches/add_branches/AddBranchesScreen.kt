package com.delminiusdevs.elektra.presentation.screens.branches.add_branches

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminiusdevs.elektra.presentation.composables.appbar.NavigationAppbar
import com.delminiusdevs.elektra.presentation.composables.cards.BranchCard
import com.delminiusdevs.elektra.presentation.composables.containers.LoadingContainer
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBranchesScreen(
    navigateBack: () -> Unit,
    viewModel: AddBranchesViewModel = hiltViewModel(),
) {
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val state = viewModel.state

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
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
        when {
            state.isLoading -> {
                LoadingContainer(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddingValues.calculateTopPadding()),
                    title = "Učitavanje poslovnica..."
                )
            }

            state.isError -> Text(text = state.errorMessage)

            else -> {
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(top = paddingValues.calculateTopPadding())
                ) {
                    items(count = state.branches.size) { index ->

                        BranchCard(
                            modifier = Modifier
                                .padding(horizontal = NORMAL_PADDING),
                            branchOffice = state.branches[index],
                            onAddClicked = { branch ->

                            }
                        )

                    }

                    item {
                        Spacer(modifier = Modifier
                            .height(NORMAL_PADDING)
                            .width(NORMAL_PADDING))
                    }
                }
            }
        }
    }
}