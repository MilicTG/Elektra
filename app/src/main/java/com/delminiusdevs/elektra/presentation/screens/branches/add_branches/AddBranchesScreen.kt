package com.delminiusdevs.elektra.presentation.screens.branches.add_branches

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.delminiusdevs.elektra.presentation.composables.appbar.InfoAppbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddBranchesScreen(
    navigateBack: () -> Unit,
){
    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            InfoAppbar(
                title = "Dodaj poslovnicu",
                scrollBehavior = scrollBehavior,
                onInfoClicked = {

                }
            )
        },
    ) { paddingValues ->

        Text(
            modifier = Modifier
                .padding(top = paddingValues.calculateTopPadding()),
            text = "Pos")
    }
}