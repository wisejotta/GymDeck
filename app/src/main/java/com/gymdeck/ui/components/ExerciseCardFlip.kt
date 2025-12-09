package com.gymdeck.ui.components

import androidx.compose.animation.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gymdeck.data.models.ExerciseCard
import com.gymdeck.data.repository.RecordLog

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ExerciseCardFlip(card: ExerciseCard) {
    var isFlipped by remember { mutableStateOf(false) }

    val userRecord = remember { RecordLog.getUserRecord(card.title) }
    val friendRecords = remember { RecordLog.getTopFriends(card.title) }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { isFlipped = !isFlipped }
            .padding(8.dp)
    ) {
        AnimatedContent(
            targetState = isFlipped,
            transitionSpec = { fadeIn() with fadeOut() }
        ) { flipped ->
            if (!flipped) {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.primaryContainer)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(card.title, style = MaterialTheme.typography.titleLarge)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Duration: ${card.duration} min")
                        Text("Type: ${card.type}")
                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Tap to view instructions", style = MaterialTheme.typography.labelSmall)
                    }
                }
            } else {
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(MaterialTheme.colorScheme.secondaryContainer)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text("🧠 Instructions", style = MaterialTheme.typography.titleMedium)
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(card.description)

                        Spacer(modifier = Modifier.height(16.dp))
                        Text("🏅 Your Best: ${userRecord?.value ?: "--"} ${card.recordUnit}")

                        Spacer(modifier = Modifier.height(8.dp))
                        Text("🏆 Top 3 Friends:")
                        friendRecords.forEach { rec ->
                            Text("• ${rec.user}: ${rec.value} ${rec.unit}")
                        }

                        Spacer(modifier = Modifier.height(8.dp))
                        Text("Tap to flip back", style = MaterialTheme.typography.labelSmall)
                    }
                }
            }
        }
    }
}
