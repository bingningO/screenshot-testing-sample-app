package com.example.reply.ui.navigation

sealed class Route(val name: String) {
    object Inbox : Route("Inbox")
    object Detail : Route("Detail")
    object Articles : Route("Articles")
    object DirectMessages : Route("DirectMessages")
    object Groups : Route("Groups")
}
