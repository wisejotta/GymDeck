package com.gymdeck.data.repository

import com.gymdeck.data.models.ExerciseCard

object FakeExerciseData {
    val exerciseList = listOf(
        ExerciseCard("1", "Push Ups", "Basic push-up for chest and triceps.", "Strength", 5),
        ExerciseCard("2", "Jump Rope", "Cardio warm-up.", "Cardio", 3),
        ExerciseCard("3", "Squats", "Lower body compound movement.", "Strength", 5),
        ExerciseCard("4", "Burpees", "Full body HIIT cardio.", "Cardio", 4),
        ExerciseCard("5", "Plank", "Core strength and endurance.", "Core", 2, recordUnit = "seconds")
    )
}
