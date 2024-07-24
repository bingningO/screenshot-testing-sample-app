package com.example.reply.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.reply.ui.routes.EmptyComingSoon
import com.example.reply.ui.routes.inbox.InboxScreen
import com.example.reply.ui.routes.inbox.InboxViewModel

@Composable
fun AppNavHost(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Route.Inbox.name) {
        composable(Route.Inbox.name) {
            InboxScreen(navController = navController)
        }
        composable(Route.Detail.name) {
            EmptyComingSoon()
        }
        composable(Route.Articles.name) {
           EmptyComingSoon()
        }
        composable(Route.DirectMessages.name) {
            EmptyComingSoon()
        }
        composable(Route.Groups.name) {
            EmptyComingSoon()
        }
    }
}

