package com.delminiusdevs.elektra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.delminiusdevs.elektra.presentation.screens.branches.main_branches.BranchesScreen
import com.delminiusdevs.elektra.presentation.screens.outages.OutagesScreen
import com.delminiusdevs.elektra.util.Constants.BASE_ROUTE

@Composable
fun SetupBaseNavigation(
    navController: NavHostController,
) {

    NavHost(
        navController = navController,
        startDestination = ApplicationScreens.OutagesScreen.route,
        route = BASE_ROUTE
    ) {

        composable(
            route = ApplicationScreens.OutagesScreen.route,
        ) {
            OutagesScreen()
        }

        composable(
            route = ApplicationScreens.BranchesScreen.route,
        ) {
            BranchesScreen()
        }
    }
}