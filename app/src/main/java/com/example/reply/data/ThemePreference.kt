package com.example.reply.data

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "settings")

class ThemePreference(private val context: Context) {

    companion object {
        private val DARK_MODE_KEY = booleanPreferencesKey("dark_mode")
        private val TYPOGRAPHY_KEY = intPreferencesKey("typography")
    }

    val isDarkMode: Flow<Boolean> = context.dataStore.data
        .map { preferences ->
            preferences[DARK_MODE_KEY] ?: false
        }

    val typographyMode: Flow<Int> = context.dataStore.data
        .map { preferences ->
            preferences[TYPOGRAPHY_KEY] ?: 0
        }

    suspend fun toggleTheme(isDark: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[DARK_MODE_KEY] = isDark
        }
    }

    suspend fun setTypographyMode(typographyValue: Int) {
        context.dataStore.edit { preferences ->
            preferences[TYPOGRAPHY_KEY] = typographyValue
        }
    }
}
