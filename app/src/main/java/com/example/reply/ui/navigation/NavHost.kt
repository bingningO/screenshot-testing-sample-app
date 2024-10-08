package com.example.reply.ui.navigation

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.reply.ui.routes.EmptyComingSoon
import com.example.reply.ui.routes.animate.AnimateScreen
import com.example.reply.ui.routes.contacts.ContactsListScreen
import com.example.reply.ui.routes.detail.DetailScreen
import com.example.reply.ui.routes.inbox.InboxScreen
import com.example.reply.ui.routes.setting.SettingScreen

@Composable
fun AppNavHost(modifier: Modifier, navController: NavHostController) {
    Surface(tonalElevation = 5.dp, modifier = modifier) {
        NavHost(navController = navController, startDestination = Route.Inbox.name) {
            composable(Route.Inbox.name) {
                InboxScreen(navController = navController)
            }
            composable(
                "${Route.Detail.name}/{emailId}",
                arguments = listOf(
                    navArgument("emailId") { type = NavType.LongType }
                )
            ) {
                DetailScreen(navController = navController)
            }
            composable(Route.Contacts.name) {
                ContactsListScreen()
            }
            composable(Route.Animation.name) {
                AnimateScreen()
            }
            composable(Route.Settings.name) {
                SettingScreen()
            }
        }
    }
}

