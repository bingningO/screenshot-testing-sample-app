package com.example.reply.ui.routes.inbox

import android.widget.Toast
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.LargeFloatingActionButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.reply.R
import com.example.reply.ui.theme.AppTheme

@Composable
fun FloatEditButton(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    LargeFloatingActionButton(
        onClick = {
            Toast.makeText(
                context,
                "Edit button clicked",
                Toast.LENGTH_SHORT
            ).show()
        },
        modifier = modifier,
        containerColor = MaterialTheme.colorScheme.tertiaryContainer,
        contentColor = MaterialTheme.colorScheme.onTertiaryContainer
    ) {
        Icon(
            imageVector = Icons.Default.Edit,
            contentDescription = stringResource(id = R.string.edit),
            modifier = Modifier.size(16.dp)
        )
    }
}

@Preview
@Composable
fun FloatEditButtonPreview() {
    AppTheme {
        FloatEditButton()
    }
}
