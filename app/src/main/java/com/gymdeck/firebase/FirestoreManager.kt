// FirestoreManager.kt — full implementation based on ChatGPT code discussion
package com.gymdeck.firebase

import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.gymdeck.data.models.SavedDeck
import com.gymdeck.data.models.WorkoutSessionEntry

object FirestoreManager {

    private val db = Firebase.firestore
    private val auth = Firebase.auth

    private fun userId(): String =
        auth.currentUser?.uid ?: throw IllegalStateException("User not authenticated")

    // Save a deck to the user's saved decks collection
    fun saveDeckToCloud(deck: SavedDeck, onComplete: (Boolean) -> Unit = {}) {
        db.collection("users").document(userId())
            .collection("saved_decks")
            .document(deck.id)
            .set(deck)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    // Retrieve all saved decks for the user
    fun getSavedDecksFromCloud(onResult: (List<SavedDeck>) -> Unit) {
        db.collection("users").document(userId())
            .collection("saved_decks")
            .get()
            .addOnSuccessListener { snapshot ->
                val decks = snapshot.toObjects(SavedDeck::class.java)
                onResult(decks)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }

    // Delete a saved deck
    fun deleteDeckFromCloud(deckId: String, onComplete: (Boolean) -> Unit = {}) {
        db.collection("users").document(userId())
            .collection("saved_decks")
            .document(deckId)
            .delete()
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    // Save a completed workout session to Firestore
    fun saveWorkoutSessionToCloud(session: WorkoutSessionEntry, onComplete: (Boolean) -> Unit = {}) {
        db.collection("users").document(userId())
            .collection("workout_history")
            .add(session)
            .addOnSuccessListener { onComplete(true) }
            .addOnFailureListener { onComplete(false) }
    }

    // Get all workout history entries
    fun getWorkoutHistoryFromCloud(onResult: (List<WorkoutSessionEntry>) -> Unit) {
        db.collection("users").document(userId())
            .collection("workout_history")
            .get()
            .addOnSuccessListener { snapshot ->
                val history = snapshot.toObjects(WorkoutSessionEntry::class.java)
                onResult(history)
            }
            .addOnFailureListener {
                onResult(emptyList())
            }
    }
}
