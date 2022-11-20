package com.twentyfourseven.designsystem.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun Theme(
    colors: Colors,
    background: Color,
    content: @Composable () -> Unit,
    darkIcons: Boolean = false
) {
    MaterialTheme(
        colors = colors,
        typography = Typography,
        content = content
    )
    val systemUiController = rememberSystemUiController()
    systemUiController.setStatusBarColor(
        color = background,
        darkIcons = darkIcons
    )
    systemUiController.setNavigationBarColor(
        color = background,
        darkIcons = darkIcons
    )
}

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
    Theme(
        colors = WhiteColorPalette,
        background = White,
        content = content,
        darkIcons = true
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
    Theme(
        colors = BlueColorPalette,
        background = BgBlue,
        content = content
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
    Theme(
        colors = RedColorPalette,
        background = BgRed,
        content = content
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
    Theme(
        colors = VioletColorPalette,
        background = BgViolet,
        content = content
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
    Theme(
        colors = GreenColorPalette,
        background = BgGreen,
        content = content
    )
}
