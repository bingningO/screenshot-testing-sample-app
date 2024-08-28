package com.example.reply.ui.routes.animate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.ui.theme.AppTheme

@Composable
fun AnimateScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        AnimatedVisibility(visible = true) {
            Column {
                Title("Android Build-in Animation")
                ProgressItems()
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
            }
        }
        AnimatedVisibility(visible = true) {
            Column {
                Title("Value-based Animation")
                AnimateButton()
                Spacer(modifier = Modifier.padding(16.dp))
                AnimateTab()
                HorizontalDivider(modifier = Modifier.padding(bottom = 16.dp, top = 32.dp))
            }
        }
        AnimatedVisibility(visible = true) {
            Column {
                Title("Animated Lottie Vector Drawable")
                AnimateLottie(modifier = Modifier.align(Alignment.CenterHorizontally))
                HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
            }
        }
    }
}

@Composable
private fun Title(text: String) {
    Text(
        text = text,
        style = MaterialTheme.typography.titleLarge,
        color = MaterialTheme.colorScheme.primary,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.padding(vertical = 16.dp)
    )
}

@Preview
@Composable
fun AnimateScreenPreview() {
    Surface  {
        AnimateScreen(modifier = Modifier.fillMaxSize())
    }
}
