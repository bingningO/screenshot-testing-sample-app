package com.example.reply

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.reply.data.dummySingleEmail
import com.example.reply.ui.routes.detail.EmailDetailAppBar
import com.example.reply.ui.theme.AppTheme

@Preview
@Composable
fun EmailDetailAppBarPreviewDelivered() {
    AppTheme {
        EmailDetailAppBar(
            email = dummySingleEmail,
            isFullScreen = true,
            onBackPressed = {}
        )
    }
}

@Preview
@Composable
fun EmailDetailAppBarPreviewShippedWithMessages() {
    AppTheme {
        EmailDetailAppBar(
            email = dummySingleEmail.copy(
                subject = "Shipped",
                threads = listOf(
                    dummySingleEmail.copy(subject = "Shipped"),
                    dummySingleEmail.copy(subject = "Shipped"),
                    dummySingleEmail.copy(subject = "Shipped"),
                )
            ),
            isFullScreen = true,
            onBackPressed = {}
        )
    }
}

@Preview
@Composable
fun EmailDetailAppBarPreviewShippedNotFullScreen() {
    AppTheme {
        EmailDetailAppBar(
            email = dummySingleEmail.copy(
                subject = "Shipped",
                threads = emptyList()
            ),
            isFullScreen = false,
            onBackPressed = {}
        )
    }
}
