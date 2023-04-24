package com.delminiusdevs.elektra.presentation.screens.branches.main_branches

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    viewModel: BranchesViewModel = hiltViewModel(),
) {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()
    val state = viewModel.state

    Scaffold(
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
                onClick = {  },
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
        }


    }
}