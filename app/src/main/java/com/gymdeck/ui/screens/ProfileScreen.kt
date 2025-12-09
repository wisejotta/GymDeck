package com.gymdeck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.gymdeck.data.repository.FakeUserData
import com.gymdeck.ui.components.AvatarPreview

@Composable
fun ProfileScreen() {
    val profile = FakeUserData.myProfile

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        AvatarPreview(metadata = null, initials = profile.avatarInitials)

        Spacer(modifier = Modifier.height(16.dp))
        Text("Name: ${profile.name}")
        Text("Stars Earned: ⭐ ${WorkoutLog.getTotalStars()}")
        Text("Workouts Completed: ${profile.completedWorkouts}")

        Spacer(modifier = Modifier.height(16.dp))
        Text("🏅 Personal Bests:")
        profile.bestRecord.forEach { (exercise, record) ->
            Text("- $exercise: $record")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text("🗓️ This Week's Activity:")
        WeeklyActivity()

    }
    Button(onClick = {
        navController.navigate(Screen.WorkoutHistory.route)
    }) {
        Text("View Workout History")
    }

}
