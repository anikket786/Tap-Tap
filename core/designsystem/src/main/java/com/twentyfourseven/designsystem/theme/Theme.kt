package com.twentyfourseven.designsystem.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.google.accompanist.systemuicontroller.rememberSystemUiController

internal val WhiteColorPalette = lightColors(
    primary = White,
    onPrimary = Black,
    onSecondary = Black,
    onError = Black,
    background = White,
    onBackground = Black,
    surface = White,
    onSurface = Black,
)

@Composable
fun WhiteTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = WhiteColorPalette,
        typography = Typography,
        content = content
    )
}

internal val BlueColorPalette = lightColors(
    primary = BgBlue,
    onPrimary = White,
    onSecondary = White,
    onError = White,
    background = BgBlue,
    onBackground = White,
    surface = BgBlue,
    onSurface = White,
)

@Composable
fun BlueTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = BlueColorPalette,
        typography = Typography,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = BgBlue,
        darkIcons = false
    )
}

internal val RedColorPalette = lightColors(
    primary = BgRed,
    onPrimary = White,
    onSecondary = White,
    onError = White,
    background = BgRed,
    onBackground = White,
    surface = BgRed,
    onSurface = White,
)

@Composable
fun RedTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = BlueColorPalette,
        typography = Typography,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = BgBlue,
        darkIcons = false
    )
}

internal val VioletColorPalette = lightColors(
    primary = BgViolet,
    onPrimary = White,
    onSecondary = White,
    onError = White,
    background = BgViolet,
    onBackground = White,
    surface = BgViolet,
    onSurface = White,
)

@Composable
fun VioletTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = VioletColorPalette,
        typography = Typography,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = BgViolet,
        darkIcons = false
    )
}

internal val GreenColorPalette = lightColors(
    primary = BgGreen,
    onPrimary = White,
    onSecondary = White,
    onError = White,
    background = BgGreen,
    onBackground = White,
    surface = BgGreen,
    onSurface = White,
)

@Composable
fun GreenTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = GreenColorPalette,
        typography = Typography,
        content = content
    )

    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = BgGreen,
        darkIcons = false
    )
}
