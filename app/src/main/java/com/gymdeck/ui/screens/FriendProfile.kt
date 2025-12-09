package com.gymdeck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavBackStackEntry
import com.gymdeck.data.repository.FakeUserData

@Composable
fun FriendProfile(backStackEntry: NavBackStackEntry) {
    val name = backStackEntry.arguments?.getString("friendName") ?: ""
    val friend = FakeUserData.friends.find { it.name == name }

    if (friend == null) {
        Text("Friend not found.")
        return
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Text("👤 ${friend.name}", style = MaterialTheme.typography.headlineSmall)
        Spacer(modifier = Modifier.height(8.dp))
        Text("⭐ Stars: ${friend.totalStars}")
        Text("🏋️‍♂️ Sessions: ${friend.completedWorkouts}")
    }
}
