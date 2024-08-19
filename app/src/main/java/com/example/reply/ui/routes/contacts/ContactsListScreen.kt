package com.example.reply.ui.routes.contacts

import android.content.res.Configuration
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.adaptive.ExperimentalMaterial3AdaptiveApi
import androidx.compose.material3.adaptive.layout.AnimatedPane
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffold
import androidx.compose.material3.adaptive.layout.ListDetailPaneScaffoldRole
import androidx.compose.material3.adaptive.navigation.rememberListDetailPaneScaffoldNavigator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.UiMode
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reply.data.Account
import com.example.reply.data.LocalAccountsDataProvider

@OptIn(ExperimentalMaterial3AdaptiveApi::class)
@Composable
fun ContactsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ContactsViewModel = hiltViewModel()
) {
    val navigator = rememberListDetailPaneScaffoldNavigator<Account>()
    val state by viewModel.uiState.collectAsState()
    val lazyListState = rememberLazyListState()

    BackHandler(navigator.canNavigateBack()) {
        navigator.navigateBack()
    }
    ListDetailPaneScaffold(
        modifier = modifier,
        directive = navigator.scaffoldDirective,
        value = navigator.scaffoldValue,
        listPane = {
            AnimatedPane(modifier = Modifier.preferredWidth(320.dp)) {
                Surface(
                    color = MaterialTheme.colorScheme.surface,
                ) {
                    ContactList(
                        accounts = state.accounts,
                        lazyListState = lazyListState
                    ) {
                        navigator.navigateTo(ListDetailPaneScaffoldRole.Detail, it)
                    }
                }
            }
        },
        detailPane = {
            AnimatedPane {
                Surface(
                    color = MaterialTheme.colorScheme.surfaceVariant,
                ) {
                    navigator.currentDestination?.content?.let {
                        ContactDetail(account = it)
                    }
                }
            }
        }
    )
}

@Preview
@Preview(device = Devices.TABLET)
@Composable
fun ContactsListScreenPreview() {
    ContactsListScreen(
        viewModel = ContactsViewModel(dataProvider = LocalAccountsDataProvider)
    )
}
