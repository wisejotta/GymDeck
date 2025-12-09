package com.gymdeck.data.repository

import com.gymdeck.data.models.RecordEntry

object RecordLog {

    private val allRecords = listOf(
        // User Records
        RecordEntry("Push Ups", "Jet", 40, "reps"),
        RecordEntry("Squats", "Jet", 60, "reps"),
        RecordEntry("Burpees", "Jet", 25, "reps"),

        // Friends Records
        RecordEntry("Push Ups", "Zoe", 50, "reps"),
        RecordEntry("Push Ups", "Lee", 45, "reps"),
        RecordEntry("Push Ups", "Mike", 48, "reps"),

        RecordEntry("Squats", "Zoe", 65, "reps"),
        RecordEntry("Squats", "Mike", 58, "reps"),
        RecordEntry("Squats", "Lee", 62, "reps"),

        RecordEntry("Burpees", "Lee", 28, "reps"),
        RecordEntry("Burpees", "Mike", 30, "reps"),
        RecordEntry("Burpees", "Zoe", 26, "reps")
    )

    fun getUserRecord(exerciseName: String): RecordEntry? {
        return allRecords.find { it.exerciseName == exerciseName && it.user == "Jet" }
    }

    fun getTopFriends(exerciseName: String): List<RecordEntry> {
        return allRecords
            .filter { it.exerciseName == exerciseName && it.user != "Jet" }
            .sortedByDescending { it.value }
            .take(3)
    }
}
