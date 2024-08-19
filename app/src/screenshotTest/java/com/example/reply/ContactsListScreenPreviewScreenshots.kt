package com.example.reply

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.reply.data.LocalAccountsDataProvider
import com.example.reply.ui.routes.contacts.ContactsListScreen
import com.example.reply.ui.routes.contacts.ContactsViewModel
import com.example.reply.ui.theme.AppTheme

@Preview
// issue: https://issuetracker.google.com/issues/360522478, not working with Devices.TABLET
//@Preview(device = Devices.TABLET)
@Composable
fun ContactsListScreenPreview() {
    AppTheme {
        ContactsListScreen(
            viewModel = ContactsViewModel(dataProvider = LocalAccountsDataProvider)
        )
    }
}
