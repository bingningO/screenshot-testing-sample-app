package com.example.reply.ui.routes.animate

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.ui.theme.AppTheme

@Composable
fun AnimateScreen(modifier: Modifier = Modifier) {
    Column(modifier = modifier.padding(16.dp)) {
        ProgressItems()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        AnimateButton()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        AnimateTab()
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
        AnimateLottie(modifier = Modifier.align(Alignment.CenterHorizontally))
        HorizontalDivider(modifier = Modifier.padding(vertical = 16.dp))
    }
}

@Preview(widthDp = 400, heightDp = 820)
@Composable
fun AnimateScreenPreview() {
    AppTheme {
        AnimateScreen(modifier = Modifier.fillMaxSize())
    }
}
