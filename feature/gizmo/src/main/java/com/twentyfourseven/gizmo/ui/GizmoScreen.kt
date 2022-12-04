package com.twentyfourseven.gizmo.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.twentyfourseven.designsystem.theme.BlueTheme
import com.twentyfourseven.gizmo.R
import kotlinx.coroutines.delay

@Composable
fun GizmoScreen(
    viewModel: GizmoViewModel = hiltViewModel()
) {
    BlueTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            var showLandingScreen by remember { mutableStateOf(true) }

            if (showLandingScreen) {
                val context = LocalContext.current
                LaunchedEffect(context) {
                    delay(500)
                    viewModel.loadSoundPool(context)
                    showLandingScreen = false
                }

                LandingScreen()
            } else {
                GizmoScreenUi(
                    size = viewModel.notesList.size,
                    onClick = viewModel::playSound
                )
            }
        }
    }
}

@Composable
private fun LandingScreen() {
    Box(modifier = Modifier.fillMaxSize()) {
        Text(
            modifier = Modifier.align(Alignment.Center),
            text = stringResource(R.string.loading)
        )
    }
}

@Composable
private fun GizmoScreenUi(
    size: Int,
    onClick: (Int) -> Unit
) {
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

    HintView()
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

@Composable
private fun HintView() {
    var showHint by rememberSaveable { mutableStateOf(true) }
    val interactionSource = remember { MutableInteractionSource() }

    AnimatedVisibility(
        visible = showHint,
        exit = slideOutVertically { -it } + fadeOut()
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .clickable(
                    interactionSource = interactionSource,
                    indication = null
                ) { showHint = false }
        ) {
            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.lottie_tap)
            )

            Column(
                modifier = Modifier
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                LottieAnimation(
                    composition = composition,
                    contentScale = ContentScale.FillBounds,
                    iterations = Int.MAX_VALUE
                )
                Text(text = stringResource(id = R.string.tap_anywhere_to_play))
            }
        }
    }
}

@Preview
@Composable
private fun GizmoScreenPreview() {
    GizmoScreenUi(size = 26, {})
}