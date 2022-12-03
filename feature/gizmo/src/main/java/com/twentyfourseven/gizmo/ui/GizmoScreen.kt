package com.twentyfourseven.gizmo.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.twentyfourseven.designsystem.theme.BlueTheme

@Composable
fun GizmoScreen(
    viewModel: GizmoViewModel = hiltViewModel(),
) {
    viewModel.loadSoundPool(LocalContext.current)
    GizmoScreenUi(
        size = viewModel.notesList.size,
        onClick = viewModel::playSound
    )
}

@Composable
private fun GizmoScreenUi(
    size: Int,
    onClick: (Int) -> Unit
) {
    BlueTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier.fillMaxSize(),
            ) {
                for (row in 0 until size) {
                    NotesRow(
                        modifier = Modifier.weight(1f),
                        startIndex = row,
                        endIndex = size - 1 + row,
                        onClick = { index ->
                            onClick(index)
                        },
                    )
                }
            }
        }
    }
}

@Composable
private fun NotesRow(
    modifier: Modifier,
    startIndex: Int,
    endIndex: Int,
    onClick: (Int) -> Unit
) {
    Row(
        modifier = modifier
    ) {
        (startIndex..endIndex).forEach { index ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .clickable {
                        onClick(index)
                    }
            )
        }
    }
}

@Preview
@Composable
private fun GizmoScreenPreview() {
    GizmoScreenUi(size = 26) {}
}