package com.gymdeck.ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun WorkoutCompleteDialog(
    onDismiss: () -> Unit,
    onConfirmRating: (Int) -> Unit
) {
    var selectedRating by remember { mutableStateOf(3) }

    AlertDialog(
        onDismissRequest = onDismiss,
        confirmButton = {
            Button(onClick = { onConfirmRating(selectedRating) }) {
                Text("Submit")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Skip")
            }
        },
        title = { Text("Rate Your Workout") },
        text = {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("How was this workout?")
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.Center) {
                    (1..3).forEach { star ->
                        IconToggleButton(
                            checked = selectedRating >= star,
                            onCheckedChange = { selectedRating = star }
                        ) {
                            Icon(
                                imageVector = if (selectedRating >= star)
                                    Icons.Default.Star else Icons.Default.StarBorder,
                                contentDescription = null
                            )
                        }
                    }
                }
            }
        }
    )
}
