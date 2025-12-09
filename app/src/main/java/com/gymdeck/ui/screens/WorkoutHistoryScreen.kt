package com.gymdeck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gymdeck.data.repository.WorkoutLog

@Composable
fun WorkoutHistoryScreen() {
    val history = WorkoutLog.getSessionHistory()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Text("📚 Workout History", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(12.dp))

        if (history.isEmpty()) {
            Text("No workouts logged yet.")
        } else {
            LazyColumn {
                items(history.reversed()) { session ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Column(Modifier.padding(16.dp)) {
                            Text("📅 ${session.date}")
                            Text("🧱 Deck Size: ${session.deckSize}")
                            Text("⭐ Rating: ${session.stars}")
                        }
                    }
                }
            }
        }
    }
}
