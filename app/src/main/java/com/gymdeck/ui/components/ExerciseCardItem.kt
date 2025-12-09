package com.gymdeck.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gymdeck.data.models.ExerciseCard

@Composable
fun ExerciseCardItem(
    card: ExerciseCard,
    isSelected: Boolean,
    onToggle: () -> Unit
) {
    Surface(
        tonalElevation = if (isSelected) 4.dp else 0.dp,
        color = if (isSelected) MaterialTheme.colorScheme.secondary else Color.White,
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onToggle() }
            .padding(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(card.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text("Type: ${card.type} • Duration: ${card.duration}min")
        }
    }
}
