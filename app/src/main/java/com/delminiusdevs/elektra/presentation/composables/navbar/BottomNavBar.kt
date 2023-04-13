package com.delminiusdevs.elektra.presentation.composables.navbar

import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.compose.currentBackStackEntryAsState
import com.delminiusdevs.elektra.presentation.ui.theme.BOTTOM_NAV_ICON_SIZE

@Composable
fun BottomNavBar(
    navController: NavController,
) {

    val navigationItems = listOf(
        BottomNavigationItem.OutagesScreenItem,
        BottomNavigationItem.BranchesScreenItem
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface,
        tonalElevation = 0.dp
    ) {
        navigationItems.forEach { screen ->
            NavigationBarItem(
                selected = currentDestination?.hierarchy?.any { it.route == screen.route } == true,
                icon = {
                    Icon(
                        painterResource(
                            id = screen.icon
                        ),
                        contentDescription = screen.title,
                        modifier = Modifier
                            .size(BOTTOM_NAV_ICON_SIZE)
                    )
                },
                label = {
                    Text(
                        text = screen.title,
                    )
                },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.onPrimary,
                    selectedTextColor = MaterialTheme.colorScheme.onBackground,
                    unselectedIconColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    unselectedTextColor = MaterialTheme.colorScheme.onBackground.copy(alpha = 0.7f),
                    indicatorColor = MaterialTheme.colorScheme.primary
                ),
                alwaysShowLabel = true,
                onClick = {
                    navController.navigate(screen.route) {
                        popUpTo(navController.graph.findStartDestination().id) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}