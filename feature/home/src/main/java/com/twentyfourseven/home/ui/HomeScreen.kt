package com.twentyfourseven.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun HomeScreen(
    navigateToGizmo: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    Column {
        Text(text = "Home Screen")
        Button(onClick =  navigateToGizmo) {
            Text(text = "Open Gizmo")
        }
    }
}