package com.gymdeck.data.repository

import com.gymdeck.data.models.ExerciseCard
import com.gymdeck.data.models.SavedDeck
import java.util.*

object DeckStore {
    private val savedDecks = mutableListOf<SavedDeck>()

    fun saveDeck(name: String, exercises: List<ExerciseCard>) {
        val deck = SavedDeck(UUID.randomUUID().toString(), name, exercises)
        savedDecks.add(deck)
    }

    fun getAllDecks(): List<SavedDeck> = savedDecks

    fun deleteDeck(id: String) {
        savedDecks.removeIf { it.id == id }
    }

    fun getDeckById(id: String): SavedDeck? = savedDecks.find { it.id == id }
}
