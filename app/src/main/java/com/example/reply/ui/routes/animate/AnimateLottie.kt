package com.example.reply.ui.routes.animate

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.reply.ui.theme.AppTheme

@Composable
fun AnimateLottie(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.Asset("lottie-sample.json"))

    val progress by animateLottieCompositionAsState(composition)

    // Display the animation
    LottieAnimation(
        modifier = modifier.size(64.dp),
        composition = composition,
        progress = { progress },
    )
}

@Preview
@Composable
fun AnimateLottiePreview() {
    AppTheme {
        AnimateLottie()
    }
}
