package com.gymdeck.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymdeck.data.repository.DeckStore
import com.gymdeck.ui.navigation.Screen

@Composable
fun SavedDecksScreen(navController: NavController) {
    val decks = remember { DeckStore.getAllDecks() }

    Column(Modifier.fillMaxSize().padding(16.dp)) {
        Text("💾 Saved Decks", style = MaterialTheme.typography.headlineSmall)

        if (decks.isEmpty()) {
            Spacer(Modifier.height(16.dp))
            Text("No decks saved yet.")
        } else {
            LazyColumn {
                items(decks) { deck ->
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                            .clickable {
                                // Load this deck into a session
                                // Save to temp store if needed
                                navController.navigate("${Screen.WorkoutSession.route}?deckId=${deck.id}")
                            }
                    ) {
                        Row(Modifier.padding(16.dp), horizontalArrangement = Arrangement.SpaceBetween) {
                            Column {
                                Text(deck.name)
                                Text("${deck.exercises.size} exercises")
                            }
                            Button(onClick = {
                                DeckStore.deleteDeck(deck.id)
                                navController.navigate(Screen.SavedDecks.route) // Refresh
                            }) {
                                Text("Delete")
                            }
                        }
                    }
                }
            }
        }
    }
}
