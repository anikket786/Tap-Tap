package com.twentyfourseven.taptap.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.twentyfourseven.gizmo.navigation.GizmoDestination
import com.twentyfourseven.gizmo.navigation.gizmoGraph
import com.twentyfourseven.home.navigation.HomeDestination
import com.twentyfourseven.home.navigation.homeGraph
import com.twentyfourseven.navigation.TapTapNavigationDestination

/**
 * Top-level navigation graph. Navigation is organized as explained at
 * https://d.android.com/jetpack/compose/nav-adaptive
 *
 * The navigation graph defined in this file defines the different top level routes. Navigation
 * within each route is handled using state and Back Handlers.
 */
@Composable
fun TapTapNavHost(
    navController: NavHostController,
    onNavigateToDestination: (TapTapNavigationDestination, String) -> Unit,
    popBack: () -> Unit,
    modifier: Modifier = Modifier,
    startDestination: String = HomeDestination.route
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        homeGraph(
            popBack = popBack,
            navigateToGizmo = {
                onNavigateToDestination(GizmoDestination, GizmoDestination.route)
            }
        )
        gizmoGraph()
    }
}