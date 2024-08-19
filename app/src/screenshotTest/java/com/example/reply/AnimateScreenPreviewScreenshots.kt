package com.example.reply

import android.graphics.Color
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewFontScale
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.tooling.preview.PreviewScreenSizes
import com.example.reply.ui.routes.animate.AnimateScreen
import com.example.reply.ui.theme.AppTheme


// issue: https://issuetracker.google.com/issues/360522478, not working with @PreviewScreenSizes
//@PreviewScreenSizes
//@PreviewFontScale
//@PreviewLightDark
@Preview(device = Devices.TABLET)
@Preview(device = Devices.PHONE)

// issue: https://issuetracker.google.com/issues/360642939, not working with Devices.PIXEL_7 and other device type
//@Preview(device = Devices.PIXEL_7, backgroundColor = 0xFFFFFFFF)
//@Preview(device =  Devices.PIXEL_4 )

@Preview(widthDp = 360, heightDp = 640)
@Preview(widthDp = 1920, heightDp = 1080)
@Preview(widthDp = 1080, heightDp = 1920)
@Composable
fun AnimateScreenPreview() {
    AppTheme {
        AnimateScreen(modifier = Modifier.fillMaxSize())
    }
}
