package com.gymdeck.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "saved_decks")
data class DeckEntity(
    @PrimaryKey
    val id: String,           // UUID or Firebase ID
    val name: String,         // Name of the saved deck, e.g., "Monday HIIT"
    val json: String          // Serialized list of ExerciseCard as JSON
)
