package com.delminiusdevs.elektra.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.delminiusdevs.elektra.presentation.screens.base.BaseScreen
import com.delminiusdevs.elektra.presentation.screens.on_boarding.OnBoardingScreen
import com.delminiusdevs.elektra.util.Constants.APP_ROUTE

@Composable
fun SetupAppNavigation(
    navController: NavHostController,
    startDestination: String = "",
) {
    NavHost(
        navController = navController,
        startDestination = ApplicationScreens.BaseScreen.route,
        route = APP_ROUTE
    ) {
        composable(
            route = ApplicationScreens.OnBoardingScreen.route,
            content = {
                OnBoardingScreen()
            }
        )

        composable(
            route = ApplicationScreens.BaseScreen.route,
            content = {
                BaseScreen()
            }
        )
    }
}