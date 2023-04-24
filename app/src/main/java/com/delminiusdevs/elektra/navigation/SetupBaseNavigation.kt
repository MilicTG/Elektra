package com.delminiusdevs.elektra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.delminiusdevs.elektra.presentation.screens.branches.add_branches.AddBranchesScreen
import com.delminiusdevs.elektra.presentation.screens.branches.main_branches.BranchesScreen
import com.delminiusdevs.elektra.presentation.screens.outages.OutagesScreen
import com.delminiusdevs.elektra.util.Constants.ADD_BRANCHES_SCREEN_ROUTE
import com.delminiusdevs.elektra.util.Constants.BASE_ROUTE
import com.delminiusdevs.elektra.util.Constants.BRANCHES_ROUTE

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
            BranchesScreen(
                navigateToAddBranchesScreen = {
                    navController.navigate(
                        ApplicationScreens.AddBranchesScreen.route
                    )
                }
            )
        }

        branchesNavGraph(navController = navController)
    }
}

fun NavGraphBuilder.branchesNavGraph(navController: NavHostController) {
    navigation(
        startDestination = ApplicationScreens.AddBranchesScreen.route,
        route = BRANCHES_ROUTE
    ) {
        composable(route = ApplicationScreens.AddBranchesScreen.route) {
            AddBranchesScreen(
                navigateBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}