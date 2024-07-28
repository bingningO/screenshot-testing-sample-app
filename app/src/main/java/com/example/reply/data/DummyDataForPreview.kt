package com.example.reply.data

import com.example.reply.R


val dummySingleAccount = Account(
    id = 9L,
    uid = 9L,
    firstName = "Google",
    lastName = "Ggg",
    email = "email",
    altEmail = "alt email",
    avatar = R.drawable.avatar_1,
)

val dummySingleEmail = Email(
    id = 7L,
    sender = dummySingleAccount,
    recipients = emptyList(),
    subject = "Delivered",
    body = "Your shoes should be waiting for you at home!",
    isStarred = false,
    isImportant = false,
    createdAt = "2 hours ago",
)

val dummyEmailList = listOf(
    Email(
        id = 5L,
        sender = LocalAccountsDataProvider.getContactAccountByUid(13L),
        recipients = listOf(LocalAccountsDataProvider.getDefaultUserAccount()),
        subject = "Update to Your Itinerary",
        body = "",
        createdAt = "2 hours ago",
    ),
    Email(
        id = 7L,
        sender = LocalAccountsDataProvider.getContactAccountByUid(9L),
        recipients = listOf(LocalAccountsDataProvider.getDefaultUserAccount()),
        subject = "Delivered",
        body = "Your shoes should be waiting for you at home!",
        isStarred = true,
        createdAt = "2 hours ago",
    ),
    Email(
        id = 9L,
        sender = LocalAccountsDataProvider.getContactAccountByUid(10L),
        recipients = listOf(LocalAccountsDataProvider.getDefaultUserAccount()),
        subject = "(No subject)",
        body = """
            Hey, 
            
            Wanted to email and see what you thought of
            """.trimIndent(),
        createdAt = "3 hours ago",
        mailbox = MailboxType.DRAFTS
    )
)
