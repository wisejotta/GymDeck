package com.gymdeck.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymdeck.ui.components.AvatarPreview
import com.gymdeck.ui.navigation.Screen

@Composable
fun HomeScreen(navController: NavController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column {
            Text("Welcome Back,", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(8.dp))

            AvatarPreview(metadata = null) // You can load real metadata later
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = { navController.navigate(Screen.DeckBuilder.route) },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Build Deck of the Day")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Text("Recent Workouts")
            Text("⭐ You’ve earned 72 stars this month!")
        }

        Button(
            onClick = { /* TODO: navigate to Profile */ },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("My Profile")
        }
    }
}
