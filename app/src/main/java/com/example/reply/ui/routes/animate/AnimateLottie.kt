package com.example.reply.ui.routes.animate

import android.os.Build
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.reply.R
import com.example.reply.ui.theme.AppTheme

@Composable
fun AnimateLottie(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.lottie_sample))
    var isPlaying by remember { mutableStateOf(true) }
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = isPlaying,
        iterations = if (Build.FINGERPRINT == "robolectric")
            // make it only play once then compose gets idle to take a screenshot, see [AnimateLottieTestByStatic]
            1
        else
            LottieConstants.IterateForever,
    )

    Column(modifier = modifier.fillMaxWidth()) {
        Text(text = "Lottie Animation", style = MaterialTheme.typography.bodyMedium)
        OutlinedButton(
            modifier = Modifier.padding(vertical = 8.dp),
            onClick = {
                isPlaying = !isPlaying
            },
            content = { Text(text = "Play or Stop") },
        )
        LottieAnimation(
            modifier = modifier
                .size(64.dp)
                .align(Alignment.CenterHorizontally),
            composition = composition,
            progress = { progress },
        )
    }
}

@Preview
@Composable
fun AnimateLottiePreview() {
    AppTheme {
        AnimateLottie()
    }
}
