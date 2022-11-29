package com.twentyfourseven.gizmo.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Button
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.twentyfourseven.designsystem.theme.BlueTheme

@Composable
fun GizmoScreen(
    viewModel: GizmoViewModel = hiltViewModel()
) {
    GizmoScreenUi()
}

@Composable
private fun GizmoScreenUi() {
    BlueTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Button(onClick =  {}, modifier = Modifier.wrapContentSize()) {
                Text(text = "Gizmo")
            }
        }
    }
}

@Preview
@Composable
private fun GizmoScreenPreview() {
    GizmoScreenUi()
}