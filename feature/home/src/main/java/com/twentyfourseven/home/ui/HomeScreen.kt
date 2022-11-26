package com.twentyfourseven.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.twentyfourseven.designsystem.theme.WhiteTheme

@Composable
fun HomeScreen(
    navigateToGizmo: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
) {
    HomeScreenUi(navigateToGizmo)
}

@Composable
private fun HomeScreenUi(navigateToGizmo: () -> Unit) {
    WhiteTheme {
        Surface(
            modifier = Modifier.fillMaxSize(),
        ) {
            Column(
                modifier = Modifier.fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Button(onClick =  navigateToGizmo) {
                    Text(text = "Open Gizmo")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewHomeScreen() {
    WhiteTheme {
        HomeScreenUi{}
    }
}