package com.delminiusdevs.elektra.presentation.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

private val LightThemeScheme = lightColorScheme(
    primary = PrimaryLightColor,
    onPrimary = TextDarkColor,
    background = BackgroundLightColor,
    onBackground = TextLightColor,
    surface = SurfaceLightColor,
    onSurface = TextLightColor,
    error = ErrorLightColor,
    onError = TextDarkColor
)

private val DarkThemeScheme = darkColorScheme(
    primary = PrimaryDarkColor,
    onPrimary = TextLightColor,
    background = BackgroundDarkColor,
    onBackground = TextDarkColor,
    surface = SurfaceDarkColor,
    onSurface = TextDarkColor,
    error = ErrorDarkColor,
    onError = TextDarkColor
)

@Composable
fun ÊléktraTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    SetStatusAndNavBarColor(darkTheme = darkTheme)

    MaterialTheme(
        colorScheme = getThemeScheme(darkTheme = darkTheme),
        typography = AppTypography,
        shapes = Shapes,
        content = content
    )
}

@Composable
fun getThemeScheme(darkTheme: Boolean): ColorScheme {

    return when (darkTheme) {
        true -> DarkThemeScheme
        false -> LightThemeScheme
    }
}

@Composable
fun SetStatusAndNavBarColor(darkTheme: Boolean) {
    val systemUiController = rememberSystemUiController()

    when (darkTheme) {
        true -> {
            systemUiController.setSystemBarsColor(
                color = DarkThemeScheme.background
            )
        }
        false -> {
            systemUiController.setSystemBarsColor(
                color = LightThemeScheme.background
            )
        }
    }
}