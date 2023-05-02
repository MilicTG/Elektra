package com.delminiusdevs.elektra.presentation.screens.branches.main_branches

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.res.painterResource
import androidx.hilt.navigation.compose.hiltViewModel
import com.delminiusdevs.elektra.R
import com.delminiusdevs.elektra.presentation.composables.appbar.InfoAppbar
import com.delminiusdevs.elektra.presentation.composables.containers.EmptyBranchesContainer
import com.delminiusdevs.elektra.presentation.ui.theme.FAB_ICON_SIZE
import com.delminiusdevs.elektra.presentation.ui.theme.NORMAL_PADDING

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchesScreen(
    navigateToAddBranchesScreen: () -> Unit,
    viewModel: BranchesViewModel = hiltViewModel(),
) {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val state = viewModel.state

    LaunchedEffect(key1 = true) {
        viewModel.onEvent(BranchesEvent.OnGetBranchOfficesFromDatabase)
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = {
            InfoAppbar(
                title = "Poslovnice",
                scrollBehavior = scrollBehavior,
                onInfoClicked = {

                }
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navigateToAddBranchesScreen()
                },
                containerColor = MaterialTheme.colorScheme.primary,
                contentColor = MaterialTheme.colorScheme.onPrimary,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_plus),
                    contentDescription = "Dodaj poslovnicu",
                    modifier = Modifier.size(FAB_ICON_SIZE)
                )
            }
        }
    ) { paddingValues ->

        if (state.savedBranches.isEmpty()) {
            EmptyBranchesContainer(
                modifier = Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        start = NORMAL_PADDING,
                        end = NORMAL_PADDING
                    ),
                title = "Ne pratite nijednu poslovnicu, za dodavanje pritisnite na +"
            )
        } else {

            LazyColumn(
                modifier = Modifier
                    .padding(
                        top = paddingValues.calculateTopPadding(),
                        start = NORMAL_PADDING,
                        end = NORMAL_PADDING
                    ),
            ) {
                items(count = state.savedBranches.size) { index ->
                    Text(text = state.savedBranches[index].name)
                }
            }
        }
    }
}