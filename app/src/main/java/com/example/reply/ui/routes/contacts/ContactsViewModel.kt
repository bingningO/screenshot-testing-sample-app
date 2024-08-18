package com.example.reply.ui.routes.contacts

import androidx.compose.runtime.Stable
import androidx.lifecycle.ViewModel
import com.example.reply.data.Account
import com.example.reply.data.LocalAccountsDataProvider
import com.example.reply.ui.routes.inbox.InboxUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class ContactsViewModel @Inject constructor(
    private val dataProvider: LocalAccountsDataProvider
): ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(ContactsUIState(loading = true))
    val uiState: StateFlow<ContactsUIState> = _uiState

    init {
        initContactList()
    }

    private fun initContactList() {
        val accounts = dataProvider.allUserContactAccounts
        _uiState.value = ContactsUIState(accounts = accounts, loading = false)
    }

    @Stable
    data class ContactsUIState(
        val accounts: List<Account> = emptyList(),
        val loading: Boolean = false,
        val error: String? = null
    )
}
