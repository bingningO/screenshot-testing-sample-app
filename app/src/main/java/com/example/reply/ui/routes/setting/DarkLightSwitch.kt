package com.example.reply.ui.routes.setting

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.data.DarkLightMode
import com.example.reply.ui.theme.AppTheme

@Composable
fun DarkLightSwitch(
    modifier: Modifier = Modifier,
    currentMode: DarkLightMode,
    onModeChanged: (DarkLightMode) -> Unit
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = "Dark Mode", modifier = Modifier.weight(1f))
        Spacer(modifier = Modifier.width(8.dp))
        Switch(
            checked = currentMode == DarkLightMode.DARK,
            onCheckedChange = { checked ->
                onModeChanged(if (checked) DarkLightMode.DARK else DarkLightMode.LIGHT)
            }
        )
    }
}

@Preview
@Composable
fun DarkLightSwitchPreviewDark() {
    AppTheme {
        DarkLightSwitch(
            modifier = Modifier,
            currentMode = DarkLightMode.DARK
        ) {}
    }
}

@Preview
@Composable
fun DarkLightSwitchPreviewLight() {
    AppTheme {
        DarkLightSwitch(
            modifier = Modifier,
            currentMode = DarkLightMode.LIGHT
        ) {}
    }
}
