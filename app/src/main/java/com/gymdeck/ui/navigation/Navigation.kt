package com.gymdeck.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.composable
import com.gymdeck.ui.screens.SplashScreen
import com.gymdeck.ui.screens.OnboardingScreen

sealed class Screen(val route: String) {
    object Splash : Screen("splash")
    object Onboarding : Screen("onboarding")
}

@Composable
fun GymDeckNavHost(navController: NavHostController = rememberNavController()) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {
        composable(Screen.Splash.route) { SplashScreen(navController) }
        composable(Screen.Onboarding.route) { OnboardingScreen(navController) }
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.DeckBuilder.route) { DeckBuilderScreen(navController) }
        composable(Screen.WorkoutSession.route) { WorkoutSessionScreen(navController) }

    }
}
object Home : Screen("home")
object DeckBuilder : Screen("deck_builder")
object WorkoutSession : Screen("workout_session?deckId={deckId}")

object WorkoutHistory : Screen("history")
object Profile : Screen("profile")
object Friends : Screen("friends")
object FriendProfile : Screen("friend_profile")
object SavedDecks : Screen("saved_decks")
object Auth : Screen("auth")

composable(Screen.Auth.route) {
    AuthScreen(navController)
}

composable(Screen.Profile.route) { ProfileScreen() }
composable(Screen.Friends.route) { FriendsScreen(navController) }

composable("${Screen.FriendProfile.route}/{friendName}") { backStackEntry ->
    FriendProfile(backStackEntry)
}
composable(Screen.WorkoutHistory.route) { WorkoutHistoryScreen() }

composable(Screen.SavedDecks.route) { SavedDecksScreen(navController) }

composable(
route = "workout_session?deckId={deckId}",
arguments = listOf(navArgument("deckId") {
    nullable = true
    defaultValue = null
})
) {
    WorkoutSessionScreen(navController)
}

