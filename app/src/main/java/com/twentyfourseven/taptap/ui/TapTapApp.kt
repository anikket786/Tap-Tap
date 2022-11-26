package com.twentyfourseven.taptap.ui

import androidx.compose.runtime.Composable
import com.twentyfourseven.taptap.navigation.TapTapNavHost

@Composable
fun TapTapApp(
    appState: TapTapAppState = rememberTapTapAppState()
) {
    TapTapNavHost(
        navController = appState.navController,
        popBack = appState::onBackClick,
        onNavigateToDestination = appState::navigate
    )
}