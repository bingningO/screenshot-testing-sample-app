package com.example.reply.ui.routes.inbox

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.reply.data.Email
import com.example.reply.ui.components.ReplyEmailListItem
import com.example.reply.ui.components.ReplySearchBar

@Composable
fun ReplyEmailList(
    emails: List<Email>,
    emailLazyListState: LazyListState,
    selectedEmail: Email? = null,
    modifier: Modifier = Modifier,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(modifier = modifier, state = emailLazyListState) {
        item {
            ReplySearchBar(modifier = Modifier.fillMaxWidth())
        }
        items(items = emails, key = { it.id }) { email ->
            ReplyEmailListItem(
                email = email,
                isSelected = email.id == selectedEmail?.id
            ) { emailId ->
                navigateToDetail(emailId)
            }
        }
    }
}
