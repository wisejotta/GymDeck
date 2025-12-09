package com.gymdeck.data.models

data class ExerciseCard(
    val id: String,
    val title: String,
    val description: String,
    val type: String, // e.g., Cardio, Strength
    val duration: Int, // in minutes
    val recordUnit: String = "reps"
)
