package com.example.reply

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewDynamicColors
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import com.example.reply.ui.routes.animate.AnimateButton
import com.example.reply.ui.theme.AppTheme

@PreviewFontScale
@PreviewLightDark
@PreviewDynamicColors
@Composable
fun AnimateButtonPreviewExtended() {
    AppTheme {
        AnimateButton(isExtendSelected = true)
    }
}

@Preview
@Composable
fun AnimateButtonPreviewNotExtended() {
    AppTheme {
        AnimateButton(isExtendSelected = false)
    }
}
