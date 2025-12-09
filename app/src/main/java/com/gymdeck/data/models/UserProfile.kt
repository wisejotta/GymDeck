package com.gymdeck.data.models

data class UserProfile(
    val name: String,
    val avatarInitials: String,
    val totalStars: Int,
    val completedWorkouts: Int,
    val bestRecord: Map<String, Int> = emptyMap()
)
