package com.example.reply.ui.routes.detail

import androidx.compose.runtime.Stable
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.example.reply.data.Email
import com.example.reply.data.LocalEmailsDataProvider
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val dataProvider: LocalEmailsDataProvider
) : ViewModel(){

    private val emailId: Long = savedStateHandle.get<Long>("emailId") ?: 0

    private val _uiState = MutableStateFlow(DetailUiState(loading = true))
    val uiState: StateFlow<DetailUiState> = _uiState

   init {
       initEmailDetail(emailId)
   }

    private fun initEmailDetail(emailId: Long) {
        Thread.sleep(500)
        val email = dataProvider.get(emailId)
        _uiState.value = DetailUiState(email = email, loading = false)
    }

    @Stable
    data class DetailUiState(
        val email: Email? = null,
        val loading: Boolean = false,
        val error: String? = null
    )
}
