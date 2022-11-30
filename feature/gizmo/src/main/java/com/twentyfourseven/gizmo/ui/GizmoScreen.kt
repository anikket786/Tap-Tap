package com.twentyfourseven.gizmo.ui

import android.media.MediaPlayer
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.twentyfourseven.designsystem.theme.AppColors
import com.twentyfourseven.designsystem.theme.BlueTheme
import com.twentyfourseven.gizmo.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Composable
fun GizmoScreen(
    viewModel: GizmoViewModel = hiltViewModel(),
) {
    GizmoScreenUi()
}

@Composable
private fun GizmoScreenUi(
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) {
    BlueTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                NotesRow(
                    modifier = Modifier.weight(1f),
                    notesList = (0..4).toList(),
                    scope = coroutineScope
                )
            }
        }
    }
}

@Composable
private fun NotesRow(
    modifier: Modifier,
    notesList: List<Int>,
    scope: CoroutineScope
) {
    val context = LocalContext.current

    Row(
        modifier = modifier
    ) {
        notesList.forEach { visualNote ->
            Box(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxSize()
                    .clickable {
                        scope.launch(Dispatchers.IO) {
                            val mediaPlayer = MediaPlayer.create(context, R.raw.bubbles)
                            mediaPlayer.start()
                        }
                    },
            )
        }
    }
}

@Preview
@Composable
private fun GizmoScreenPreview() {
    GizmoScreenUi()
}