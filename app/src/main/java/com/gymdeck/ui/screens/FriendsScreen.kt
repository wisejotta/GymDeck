package com.gymdeck.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymdeck.data.repository.FakeUserData
import com.gymdeck.ui.navigation.Screen

@Composable
fun FriendsScreen(navController: NavController) {
    val friends = FakeUserData.friends

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        items(friends) { friend ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable {
                        navController.navigate("${Screen.FriendProfile.route}/${friend.name}")
                    }
            ) {
                Column(Modifier.padding(16.dp)) {
                    Text(friend.name, style = MaterialTheme.typography.titleMedium)
                    Text("⭐ ${friend.totalStars} stars • ${friend.completedWorkouts} workouts")
                }
            }
        }
    }
}
