package com.twentyfourseven.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.twentyfourseven.home.ui.HomeScreen
import com.twentyfourseven.navigation.TapTapNavigationDestination

object HomeDestination : TapTapNavigationDestination {
    override val route = "home_route"
    override val destination = "home_destination"
}

fun NavGraphBuilder.homeGraph(
    navigateToGizmo: () -> Unit,
    popBack: () -> Unit
) {
    composable(route = HomeDestination.route) {
        HomeScreen(
            navigateToGizmo
        )
    }
}