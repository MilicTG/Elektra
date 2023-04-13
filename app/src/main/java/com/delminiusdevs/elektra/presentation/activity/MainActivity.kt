package com.delminiusdevs.elektra.presentation.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.delminiusdevs.elektra.navigation.SetupAppNavigation
import com.delminiusdevs.elektra.presentation.ui.theme.ÊléktraTheme

class MainActivity : ComponentActivity() {

    private lateinit var navController: NavHostController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ÊléktraTheme {

                navController = rememberNavController()
                SetupAppNavigation(
                    navController = navController,
                )
            }
        }
    }
}
