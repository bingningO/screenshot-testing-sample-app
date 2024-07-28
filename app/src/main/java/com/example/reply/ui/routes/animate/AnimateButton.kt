package com.example.reply.ui.routes.animate

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.ui.theme.AppTheme

@Composable
fun AnimateButton(modifier: Modifier = Modifier) {
    var isExtended by remember { mutableStateOf(true) }

    Box(modifier = modifier.fillMaxWidth()) {
        FloatingActionButton(
            modifier = Modifier
                .padding(horizontal = 16.dp, vertical = 8.dp),
            onClick = {
                // do nothing
            },
            content = {
                Row(modifier = Modifier.padding(8.dp)) {
                    Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                    AnimatedVisibility(isExtended) {
                        Text(
                            text = "EDIT",
                            modifier = Modifier.padding(start = 8.dp, top = 3.dp)
                        )
                    }
                }
            }
        )
        Row(
            modifier = Modifier.align(Alignment.BottomEnd)
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(text = "Button Extended")
            Spacer(modifier = Modifier.width(8.dp))
            Switch(checked = isExtended, onCheckedChange = {
                isExtended = !isExtended
            })
        }
    }
}

@Preview
@Composable
fun AnimateButtonPreview() {
    AppTheme {
        AnimateButton()
    }
}
