package com.delminiusdevs.elektra.presentation.screens.base

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.delminiusdevs.elektra.navigation.SetupBaseNavigation
import com.delminiusdevs.elektra.presentation.composables.navbar.BottomNavBar

@Composable
fun BaseScreen() {

    val navBottomController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navBottomController,
            )
        }
    ) { padding ->
        Box(
            modifier = Modifier
                .padding(
                    bottom = padding.calculateBottomPadding()
                )
        ) {
            SetupBaseNavigation(
                navController = navBottomController
            )
        }
    }
}