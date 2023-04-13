package com.delminiusdevs.elektra.navigation

import com.delminiusdevs.elektra.util.Constants.BASE_SCREEN_ROUTE
import com.delminiusdevs.elektra.util.Constants.BRANCHES_SCREEN_ROUTE
import com.delminiusdevs.elektra.util.Constants.ON_BOARDING_SCREEN_ROUTE
import com.delminiusdevs.elektra.util.Constants.OUTAGES_SCREEN_ROUTE

sealed class ApplicationScreens(val route: String) {
    object OnBoardingScreen : ApplicationScreens(route = ON_BOARDING_SCREEN_ROUTE)
    object BaseScreen : ApplicationScreens(route = BASE_SCREEN_ROUTE)
    object OutagesScreen : ApplicationScreens(route = OUTAGES_SCREEN_ROUTE)
    object BranchesScreen : ApplicationScreens(route = BRANCHES_SCREEN_ROUTE)
}
