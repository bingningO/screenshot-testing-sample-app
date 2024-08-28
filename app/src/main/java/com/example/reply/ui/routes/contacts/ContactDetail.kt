package com.example.reply.ui.routes.contacts

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.data.Account
import com.example.reply.data.dummySingleAccount
import com.example.reply.ui.common.ProfileImage
import com.example.reply.ui.theme.AppTheme

@Composable
fun ContactDetail(
    modifier: Modifier = Modifier,
    account: Account
) {
    LazyColumn (
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ProfileImage(
                modifier = Modifier.size(100.dp),
                drawableResource = account.avatar,
                description = account.getFullName(),
            )
        }
        item {
            Spacer(modifier = Modifier.height(16.dp))
        }
        item {
            Text(
                text = account.getFullName(),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold
            )
        }
        item {
            Spacer(modifier = Modifier.height(8.dp))
        }
        item {
            AccountInfoRow("ID:", account.id.toString())
        }
        item {
            AccountInfoRow("UID:", account.uid.toString())
        }
        item {
            AccountInfoRow("Email:", account.email)
        }
        item {
            AccountInfoRow("Alt Email:", account.altEmail)
        }
        item {
            AccountInfoRow("Current Account:", account.isCurrentAccount.toString())
        }
    }
}

@Composable
private fun AccountInfoRow(label: String, value: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.width(100.dp)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Preview
@Composable
fun ContactDetailPreview() {
    AppTheme {
        ContactDetail(account = dummySingleAccount)
    }
}
