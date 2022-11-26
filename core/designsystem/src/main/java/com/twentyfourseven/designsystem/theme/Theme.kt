package com.twentyfourseven.designsystem.theme

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
internal fun Theme(
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
    primary = AppColors.Black,
    onPrimary = AppColors.White,
    secondary = AppColors.Black,
    onSecondary = AppColors.White,
    onError = AppColors.Black,
    background = AppColors.White,
    onBackground = AppColors.Black,
    surface = AppColors.White,
    onSurface = AppColors.Black,
)

@Composable
fun WhiteTheme(
    content: @Composable () -> Unit
) {
    Theme(
        colors = WhiteColorPalette,
        background = AppColors.White,
        content = content,
        darkIcons = true
    )
}

internal val BlueColorPalette = lightColors(
    primary = AppColors.White,
    onPrimary = AppColors.Black,
    secondary = AppColors.White,
    onSecondary = AppColors.Black,
    onError = AppColors.White,
    background = AppColors.BgBlue,
    onBackground = AppColors.White,
    surface = AppColors.BgBlue,
    onSurface = AppColors.White,
)

@Composable
fun BlueTheme(
    content: @Composable () -> Unit
) {
    Theme(
        colors = BlueColorPalette,
        background = AppColors.BgBlue,
        content = content
    )
}

internal val RedColorPalette = lightColors(
    primary = AppColors.White,
    onPrimary = AppColors.Black,
    secondary = AppColors.White,
    onSecondary = AppColors.Black,
    onError = AppColors.White,
    background = AppColors.BgRed,
    onBackground = AppColors.White,
    surface = AppColors.BgRed,
    onSurface = AppColors.White,
)

@Composable
fun RedTheme(
    content: @Composable () -> Unit
) {
    Theme(
        colors = RedColorPalette,
        background = AppColors.BgRed,
        content = content
    )
}

internal val VioletColorPalette = lightColors(
    primary = AppColors.White,
    onPrimary = AppColors.Black,
    secondary = AppColors.White,
    onSecondary = AppColors.Black,
    onError = AppColors.White,
    background = AppColors.BgViolet,
    onBackground = AppColors.White,
    surface = AppColors.BgViolet,
    onSurface = AppColors.White,
)

@Composable
fun VioletTheme(
    content: @Composable () -> Unit
) {
    Theme(
        colors = VioletColorPalette,
        background = AppColors.BgViolet,
        content = content
    )
}

internal val GreenColorPalette = lightColors(
    primary = AppColors.White,
    onPrimary = AppColors.Black,
    secondary = AppColors.White,
    onSecondary = AppColors.Black,
    onError = AppColors.White,
    background = AppColors.BgGreen,
    onBackground = AppColors.White,
    surface = AppColors.BgGreen,
    onSurface = AppColors.White,
)

@Composable
fun GreenTheme(
    content: @Composable () -> Unit
) {
    Theme(
        colors = GreenColorPalette,
        background = AppColors.BgGreen,
        content = content
    )
}
