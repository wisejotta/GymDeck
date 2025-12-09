package com.gymdeck.data.models

data class SavedDeck(
    val id: String,
    val name: String,
    val exercises: List<ExerciseCard>
)
