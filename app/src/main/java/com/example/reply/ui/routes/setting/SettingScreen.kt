package com.example.reply.ui.routes.setting

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reply.data.DarkLightMode
import com.example.reply.ui.theme.AppTheme

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    Log.d("SettingScreen", "state: $state")
    val context = LocalContext.current
    Column(modifier = modifier) {
        DarkLightSwitch(currentMode = state.darkLightMode) { mode ->
            Toast.makeText(context, "Mode changed: $mode", Toast.LENGTH_SHORT).show()
            viewModel.toggleTheme(mode)
        }
    }
}

@Preview
@Composable
fun SettingScreenPreview() {
    AppTheme {
        SettingScreen()
    }
}
