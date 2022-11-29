package com.twentyfourseven.home.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.window.DialogProperties
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.rememberLottieComposition
import com.twentyfourseven.designsystem.theme.WhiteTheme
import com.twentyfourseven.home.R

@Composable
fun ComingSoonAlertDialog(
    onDismissRequest: () -> Unit
) {
    AlertDialog(
        properties = DialogProperties(
            dismissOnBackPress = true,
            dismissOnClickOutside = false
        ),
        onDismissRequest = onDismissRequest,
        confirmButton = {
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = { onDismissRequest() }
            ) {
                Text(text = stringResource(R.string.got_it))
            }
        },
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.coming_soon),
                fontWeight = FontWeight.SemiBold,
                textAlign = TextAlign.Center,
            )
        },
        text = {
            val composition by rememberLottieComposition(
                spec = LottieCompositionSpec.RawRes(R.raw.lottie_coming_soon)
            )

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(1f)
            ) {
                LottieAnimation(
                    modifier = Modifier.fillMaxWidth(),
                    composition = composition,
                    contentScale = ContentScale.FillBounds,
                    iterations = Int.MAX_VALUE
                )
            }
        }
    )
}

@Preview
@Composable
private fun ComingSoonDialogPreview() {
    WhiteTheme {
        ComingSoonAlertDialog {

        }
    }
}