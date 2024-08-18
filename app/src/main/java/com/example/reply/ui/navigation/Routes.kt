package com.example.reply.ui.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Animation
import androidx.compose.material.icons.filled.Contacts
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Inbox
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class Route(val name: String, val icon: ImageVector) {
    object Inbox : Route("Inbox", Icons.Filled.Inbox)
    object Detail : Route("Detail", Icons.Filled.Details)
    object Contacts : Route("Contacts", Icons.Filled.Contacts)
    object Animation : Route("Animation", Icons.Filled.Animation)
    object Settings : Route("Settings", Icons.Filled.Settings)
}
