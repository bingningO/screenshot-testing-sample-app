package com.example.reply

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.datastore.preferences.protobuf.Api
import com.example.reply.data.dummySingleEmail
import com.example.reply.ui.routes.detail.ReplyEmailThreadItem
import com.example.reply.ui.theme.AppTheme

@Preview
@Composable
fun ReplyEmailThreadItemPreview() {
    AppTheme {
        ReplyEmailThreadItem(
            email = dummySingleEmail
        )
    }
}

@Preview
@Composable
fun ReplyEmailThreadItemPreviewStarred() {
    AppTheme {
        ReplyEmailThreadItem(
            email = dummySingleEmail.copy(isStarred = true)
        )
    }
}

@Preview
@Composable
fun ReplyEmailThreadItemPreviewLongText() {
    AppTheme {
        ReplyEmailThreadItem(
            email = dummySingleEmail.copy(
                body = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                        "Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. " +
                        "Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
            )
        )
    }
}
