package com.twentyfourseven.gizmo.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.twentyfourseven.gizmo.ui.GizmoScreen
import com.twentyfourseven.navigation.TapTapNavigationDestination

object GizmoDestination : TapTapNavigationDestination {
    override val route = "gizmo_route"
    override val destination = "gizmo_destination"
}

fun NavGraphBuilder.gizmoGraph() {
    composable(route = GizmoDestination.route) {
        GizmoScreen()
    }
}