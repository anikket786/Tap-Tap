package com.twentyfourseven.gizmo.ui

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun GizmoScreen(
    viewModel: GizmoViewModel = hiltViewModel()
) {
    Text(text = "Gizmo Screen")
}