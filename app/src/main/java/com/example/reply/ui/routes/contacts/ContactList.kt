package com.example.reply.ui.routes.contacts

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.data.Account
import com.example.reply.data.dummySingleAccount
import com.example.reply.ui.common.ProfileImage

@Composable
fun ContactList(
    modifier: Modifier = Modifier,
    accounts: List<Account>,
    lazyListState: LazyListState,
    onClickItem: (Account) -> Unit
) {
    LazyColumn(
        modifier = modifier,
        state = lazyListState
    ) {
        items(items = accounts, key = { it.id }) { account ->
            ContactListItem(
                account = account,
                onClick = { onClickItem(account) }
            )
        }
    }
}

@Composable
private fun ContactListItem(
    modifier: Modifier = Modifier,
    account: Account,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                onClick()
            },
        verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
    ) {
        ProfileImage(
            drawableResource = account.avatar,
            description = account.getFullName()
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = account.getFullName(),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun ContactListPreview() {
    ContactList(
        accounts = listOf(
            dummySingleAccount,
            dummySingleAccount.copy(id = 2, firstName = "John"),
            dummySingleAccount.copy(id = 3, firstName = "Jane")
        ),
        lazyListState = LazyListState(),
        onClickItem = {}
    )
}

