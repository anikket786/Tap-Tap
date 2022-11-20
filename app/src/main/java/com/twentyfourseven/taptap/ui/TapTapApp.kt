package com.twentyfourseven.taptap.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.twentyfourseven.designsystem.theme.paddingMedium
import com.twentyfourseven.taptap.navigation.TapTapNavHost

@Composable
fun TapTapApp(
    appState: TapTapAppState = rememberTapTapAppState()
) {
    TapTapNavHost(
        navController = appState.navController,
        popBack = appState::onBackClick,
        onNavigateToDestination = appState::navigate,
        modifier = Modifier.padding(paddingMedium)
    )
}