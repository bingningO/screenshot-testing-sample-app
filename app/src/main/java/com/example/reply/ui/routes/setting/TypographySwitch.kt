package com.example.reply.ui.routes.setting

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.data.TypographyMode
import com.example.reply.ui.theme.AppTheme

@Composable
fun TypographySwitch(
    modifier: Modifier = Modifier,
    currentMode: TypographyMode,
    onModeChanged: (TypographyMode) -> Unit
) {
    val typographyOptions = listOf(TypographyMode.DEFAULT, TypographyMode.ABEEZEE, TypographyMode.ARE_YOU_SERIOUS)
    Column(
        modifier = modifier
            .selectableGroup()
            .fillMaxWidth()
    ) {
        typographyOptions.forEach { typographyMode ->
            TypographyItem(
                selected = currentMode == typographyMode,
                onClick = { onModeChanged(typographyMode) },
                typographyMode = typographyMode
            )
        }
    }
}

@Composable
private fun TypographyItem(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onClick: () -> Unit,
    typographyMode: TypographyMode
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .selectable(selected = selected, onClick = onClick)
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        RadioButton(selected = selected, onClick = null)
        Text(
            text = typographyMode.name,
            style =  MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(start = 8.dp)
            )
    }
}

@Preview
@Composable
fun TypographySwitchPreview() {
    AppTheme {
        TypographySwitch(
            modifier = Modifier,
            currentMode = TypographyMode.DEFAULT
        ) {}
    }
}
