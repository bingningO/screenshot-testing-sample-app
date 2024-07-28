package com.example.reply.ui.routes.inbox

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.reply.data.Email
import com.example.reply.data.LocalAccountsDataProvider
import com.example.reply.data.MailboxType
import com.example.reply.data.dummyEmailList

@Composable
fun ReplyEmailList(
    modifier: Modifier = Modifier,
    emails: List<Email>,
    emailLazyListState: LazyListState,
    navigateToDetail: (Long) -> Unit
) {
    LazyColumn(modifier = modifier, state = emailLazyListState) {
        item {
            ReplySearchBar(modifier = Modifier.fillMaxWidth())
        }
        items(items = emails, key = { it.id }) { email ->
            ReplyEmailListItem(
                email = email,
            ) { emailId ->
                navigateToDetail(emailId)
            }
        }
    }
}

@Preview
@Composable
fun ReplyEmailListPreview() {
    ReplyEmailList(emails = dummyEmailList, emailLazyListState = LazyListState(), navigateToDetail = {})
}
