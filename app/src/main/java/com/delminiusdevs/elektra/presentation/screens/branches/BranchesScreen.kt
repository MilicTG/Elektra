package com.delminiusdevs.elektra.presentation.screens.branches

import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.delminiusdevs.elektra.presentation.composables.appbar.InfoAppbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BranchesScreen() {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

    Scaffold(
        topBar = {
            InfoAppbar(
                title = "Poslovnice",
                scrollBehavior = scrollBehavior,
                onInfoClicked = {

                }
            )
        }
    ) {

        Text(text = "Branches")
    }
}