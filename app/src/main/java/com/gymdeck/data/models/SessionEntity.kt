package com.gymdeck.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "workout_history")
data class SessionEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val date: String,         // Format: yyyy-MM-dd
    val stars: Int,           // Rating: 1–3 stars
    val deckSize: Int         // Number of cards in the workout
)
