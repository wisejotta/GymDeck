package com.gymdeck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymdeck.data.models.ExerciseCard
import com.gymdeck.data.repository.FakeExerciseData
import com.gymdeck.ui.components.ExerciseCardFlip
import com.gymdeck.ui.components.WorkoutTimer

@Composable
fun WorkoutSessionScreen(navController: NavController) {
    val deckId = navController.currentBackStackEntry?.arguments?.getString("deckId")
    val session = remember {
        if (deckId != null) {
            DeckStore.getDeckById(deckId)?.exercises?.toMutableList() ?: mutableListOf()
        } else {
            FakeExerciseData.exerciseList.toMutableList()
        }
    }

    var currentIndex by remember { mutableStateOf(0) }
    val currentCard = session.getOrNull(currentIndex)
    var isMuted by remember { mutableStateOf(false) }

    if (currentCard == null) {
        // No more cards
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Workout complete!", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(20.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text("Back to Home")
            }
        }
        return
    }
    var showRating by remember { mutableStateOf(false) }
    var workoutCompleted by remember { mutableStateOf(false) }

    if (currentCard == null && !workoutCompleted) {
        workoutCompleted = true
        showRating = true
    }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            ExerciseCardFlip(card = currentCard)
            Spacer(modifier = Modifier.height(24.dp))
            WorkoutTimer(duration = currentCard.duration, isMuted = isMuted)
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(onClick = { currentIndex++ }) {
                Text("Skip")
            }
            Button(onClick = { currentIndex++ }) {
                Text("Next")
            }
        }

        TextButton(
            onClick = { isMuted = !isMuted },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(if (isMuted) "Unmute Timer" else "Mute Timer")
        }
    }

}

if (showRating) {
    WorkoutCompleteDialog(
        onDismiss = {
            showRating = false
            navController.popBackStack()
        },
        onConfirmRating = { stars ->
            WorkoutLog.logWorkout("deck-${System.currentTimeMillis()}", stars, deckSize = session.size)
            showRating = false
            navController.popBackStack()
        }
    )
}

