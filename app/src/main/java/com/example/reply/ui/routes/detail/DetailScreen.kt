package com.example.reply.ui.routes.detail

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.reply.data.Email
import com.example.reply.ui.common.LoadingContent

@Composable
fun DetailScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    viewModel: DetailViewModel = hiltViewModel()
) {
    val state by viewModel.uiState.collectAsState()
    when {
        state.loading -> {
            LoadingContent(modifier = modifier)
        }
        state.error != null -> {
            // todo
        }
        state.email != null -> {
            ReplyEmailDetail(
                modifier = modifier,
                email = state.email!!,
                onBackPressed = {
                    navController.popBackStack()
                }
            )
        }
        else -> {
            // todo
        }
    }
}

@Composable
fun ReplyEmailDetail(
    modifier: Modifier = Modifier,
    email: Email,
    isFullScreen: Boolean = true,
    onBackPressed: () -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .padding(top = 16.dp)
    ) {
        item {
            EmailDetailAppBar(email, isFullScreen) {
                onBackPressed()
            }
        }
        items(items = email.threads, key = { it.id }) { email ->
            ReplyEmailThreadItem(email = email)
        }
    }
}
