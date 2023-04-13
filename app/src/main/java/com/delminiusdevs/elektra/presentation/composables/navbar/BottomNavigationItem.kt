package com.delminiusdevs.elektra.presentation.composables.navbar

import com.delminiusdevs.elektra.navigation.ApplicationScreens
import com.delminiusdevs.elektra.R
import com.delminiusdevs.elektra.util.Constants.BRANCHES_ICON_TITLE
import com.delminiusdevs.elektra.util.Constants.OUTAGES_ICON_TITLE

sealed class BottomNavigationItem(var route: String, var icon: Int, var title: String) {

    object OutagesScreenItem : BottomNavigationItem(
        route = ApplicationScreens.OutagesScreen.route,
        icon = R.drawable.ic_bolt,
        title = OUTAGES_ICON_TITLE
    )

    object BranchesScreenItem : BottomNavigationItem(
        route = ApplicationScreens.BranchesScreen.route,
        icon = R.drawable.ic_building,
        title = BRANCHES_ICON_TITLE
    )
}
