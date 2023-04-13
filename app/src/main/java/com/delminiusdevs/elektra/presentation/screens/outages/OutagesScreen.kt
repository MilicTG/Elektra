package com.delminiusdevs.elektra.presentation.screens.outages

import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import com.delminiusdevs.elektra.presentation.composables.appbar.OutagesAppbar

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutagesScreen() {

    val scrollBehavior = TopAppBarDefaults.exitUntilCollapsedScrollBehavior()

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
        Text(text = "Outages")
    }
}