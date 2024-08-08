package com.example.reply

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.reply.ui.routes.animate.AnimateScreen
import com.example.reply.ui.theme.AppTheme

@PreviewScreenSizes
@PreviewFontScale
@PreviewLightDark
@Composable
fun AnimateScreenPreview() {
    AppTheme {
        AnimateScreen(modifier = Modifier.fillMaxSize())
    }
}
