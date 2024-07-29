package com.example.reply.ui.routes.setting

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reply.data.DarkLightMode
import com.example.reply.data.ThemePreference
import com.example.reply.data.TypographyMode
import com.example.reply.module.IoDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val themePreference: ThemePreference,
) : ViewModel() {

    private val _uiState = MutableStateFlow(SettingUIState(loading = true))
    val uiState: StateFlow<SettingUIState> = _uiState

    init {
        viewModelScope.launch {
            initTheme()
            _uiState.value = _uiState.value.copy(loading = false)
        }
    }

    private suspend fun initTheme() {
        setDarkOrLightMode()
        setTypographyMode()
    }

    private suspend fun setDarkOrLightMode() {
        val isDark = themePreference.isDarkMode.first()
        _uiState.value = _uiState.value.copy(darkLightMode = if (isDark) DarkLightMode.DARK else DarkLightMode.LIGHT)

    }

    private suspend fun setTypographyMode() {
        val typographyValue = themePreference.typographyMode.first()
        _uiState.value = _uiState.value.copy(typographyMode = TypographyMode.entries[typographyValue])
    }

    // UI Input
    fun toggleTheme(mode: DarkLightMode) {
        viewModelScope.launch {
            themePreference.toggleTheme(mode == DarkLightMode.DARK)
            setDarkOrLightMode()
        }
    }

    fun changeTypographyMode(mode: TypographyMode) {
        viewModelScope.launch {
            themePreference.setTypographyMode(mode.ordinal)
            setTypographyMode()
        }
    }

    data class SettingUIState(
        val darkLightMode: DarkLightMode? = null,
        val typographyMode: TypographyMode? = null,
        val loading: Boolean = false,
    )
}
