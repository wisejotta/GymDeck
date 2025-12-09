package com.gymdeck.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.gymdeck.ui.navigation.Screen
import kotlinx.coroutines.delay
import com.gymdeck.R

@Composable
fun SplashScreen(navController: NavController) {
    var visible by remember { mutableStateOf(false) }

    LaunchedEffect(true) {
        visible = true
        delay(2000)
        navController.navigate(Screen.Onboarding.route) {
            popUpTo(Screen.Splash.route) { inclusive = true }
        }
    }

    AnimatedVisibility(
        visible = visible,
        enter = fadeIn() + scaleIn(),
        exit = fadeOut(),
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
            Image(
                painter = painterResource(id = R.drawable.ic_gymdeck_logo),
                contentDescription = "Gym Deck Logo"
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Gym Deck", style = MaterialTheme.typography.headlineMedium)
        }
    }
}




// Note: Replace R.drawable.ic_gymdeck_logo with your own logo or add a placeholder PNG in your /res/drawable directory.