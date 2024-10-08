package com.example.reply.ui.routes.setting

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.reply.data.DarkLightMode
import com.example.reply.data.TypographyMode
import com.example.reply.data.dummySettingUIState
import com.example.reply.ui.common.LoadingContent
import com.example.reply.ui.theme.AppTheme

@Composable
fun SettingScreen(
    modifier: Modifier = Modifier,
    viewModel: SettingViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    if(state.darkLightMode != null && state.typographyMode != null) {
        SettingScreenSuccess(
            modifier = modifier,
            state = state,
            toggleTheme = {
                viewModel.toggleTheme(it)
            },
            changeTypographyMode = {
                viewModel.changeTypographyMode(it)
            }
        )
    } else {
        LoadingContent()
    }
}

@Composable
fun SettingScreenSuccess(
    modifier: Modifier,
    state: SettingViewModel.SettingUIState,
    toggleTheme: (DarkLightMode) -> Unit,
    changeTypographyMode: (TypographyMode) -> Unit
) {
    val context = LocalContext.current
    Column(modifier = modifier.padding(16.dp)) {
        Title("Theme")
        DarkLightSwitch(currentMode = state.darkLightMode!!) { mode ->
            Toast.makeText(context, "Theme changed: $mode", Toast.LENGTH_SHORT).show()
            toggleTheme(mode)
        }
        HorizontalDivider()
        Title("Typography")
        TypographySwitch(currentMode = state.typographyMode!!) { mode ->
            Toast.makeText(context, "Typography changed: $mode", Toast.LENGTH_SHORT).show()
            changeTypographyMode(mode)
        }
    }
}

@Composable
private fun Title(title: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        text = title,
        fontWeight = FontWeight.Bold,
        style = MaterialTheme.typography.titleLarge
    )
}

@Preview
@Composable
fun SettingScreenPreview() {
    AppTheme {
        Title("Title test")
    }
}

@Preview
@Composable
fun SettingScreenSuccessPreview() {
    AppTheme {
        SettingScreenSuccess(
            modifier = Modifier,
            state = dummySettingUIState,
            toggleTheme = {},
            changeTypographyMode = {}
        )
    }
}
