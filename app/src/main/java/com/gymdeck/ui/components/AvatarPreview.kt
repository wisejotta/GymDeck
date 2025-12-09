package com.gymdeck.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gymdeck.data.models.UserMetadata

@Composable
fun AvatarPreview(metadata: UserMetadata? = null, initials: String? = null) {
    val displayInitial = initials ?: metadata?.name?.take(1)?.uppercase() ?: "?"
    Box(
        modifier = Modifier
            .size(120.dp)
            .background(MaterialTheme.colorScheme.primary, shape = MaterialTheme.shapes.large),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = displayInitial,
            style = MaterialTheme.typography.headlineLarge,
            color = Color.White
        )
    }
    Spacer(modifier = Modifier.height(8.dp))
    Text("Avatar Preview")
}

