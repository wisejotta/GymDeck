package com.gymdeck.ui

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import com.gymdeck.ui.navigation.GymDeckNavHost
import com.gymdeck.ui.theme.GymDeckTheme

@Composable
fun App() {
    GymDeckTheme {
        val navController = rememberNavController()
        LaunchedEffect(Unit) {
            if (!FirebaseAuthManager.isAuthenticated) {
                navController.navigate(Screen.Auth.route)
            }
        }
        GymDeckNavHost(navController)
    }
}

