/*
 * Copyright 2022 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.reply.ui.routes.inbox

import androidx.lifecycle.ViewModel
import com.example.reply.data.Email
import com.example.reply.data.LocalEmailsDataProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class InboxViewModel @Inject constructor(
    private val emailsDataProvider: LocalEmailsDataProvider
) : ViewModel() {

    // UI state exposed to the UI
    private val _uiState = MutableStateFlow(InboxUIState(loading = true))
    val uiState: StateFlow<InboxUIState> = _uiState

    init {
        initEmailList()
    }

    private fun initEmailList() {
        val emails = emailsDataProvider.allEmails
        _uiState.value = InboxUIState(emails = emails, loading = false)
    }
}

data class InboxUIState(
    val emails: List<Email> = emptyList(),
    val loading: Boolean = false,
    val error: String? = null
)
