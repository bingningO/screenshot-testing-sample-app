package com.example.reply.ui.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.reply.ui.routes.EmptyComingSoon
import com.example.reply.ui.routes.inbox.InboxScreen
import com.example.reply.ui.routes.inbox.InboxViewModel

@Composable
fun AppNavHost(modifier: Modifier, navController: NavHostController) {
    Surface(tonalElevation = 5.dp, modifier = modifier) {
        NavHost(navController = navController, startDestination = Route.Inbox.name) {
            composable(Route.Inbox.name) {
                InboxScreen(navController = navController)
            }
            composable(Route.Detail.name) {
                EmptyComingSoon()
            }
            composable(Route.Animation.name) {
                EmptyComingSoon()
            }
            composable(Route.Settings.name) {
                EmptyComingSoon()
            }
        }
    }
}

