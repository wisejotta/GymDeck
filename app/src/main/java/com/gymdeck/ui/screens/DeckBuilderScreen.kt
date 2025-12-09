package com.gymdeck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymdeck.data.models.ExerciseCard
import com.gymdeck.data.repository.FakeExerciseData
import com.gymdeck.ui.components.ExerciseCardItem

@Composable
fun DeckBuilderScreen(navController: NavController) {
    val allExercises = remember { FakeExerciseData.exerciseList }
    val selected = remember { mutableStateListOf<ExerciseCard>() }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Text("Select Exercises", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(allExercises) { card ->
                ExerciseCardItem(
                    card = card,
                    isSelected = selected.contains(card),
                    onToggle = {
                        if (selected.contains(card)) selected.remove(card)
                        else selected.add(card)
                    }
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

        if (selected.isNotEmpty()) {
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    // TODO: Save deck for session
                    navController.popBackStack()
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Confirm Deck (${selected.size})")
            }
        }
        var showSaveDialog by remember { mutableStateOf(false) }

        if (showSaveDialog) {
            SaveDeckDialog(
                deck = selected,
                onSave = {
                    DeckStore.saveDeck(it, selected.toList())
                    showSaveDialog = false
                },
                onDismiss = { showSaveDialog = false }
            )
        }

        Button(
            onClick = { showSaveDialog = true },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Save as Favorite")
        }


    }
}
