package com.gymdeck.data.repository

import com.gymdeck.data.models.UserProfile

object FakeUserData {
    val myProfile = UserProfile(
        name = "Jet",
        avatarInitials = "J",
        totalStars = 72,
        completedWorkouts = 21,
        bestRecord = mapOf(
            "Push Ups" to 45,
            "Squats" to 60
        )
    )

    val friends = listOf(
        UserProfile("Zoe", "Z", 88, 24),
        UserProfile("Mike", "M", 64, 19),
        UserProfile("Lee", "L", 120, 30)
    )
}
