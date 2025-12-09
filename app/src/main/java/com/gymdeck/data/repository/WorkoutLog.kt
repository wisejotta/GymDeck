package com.gymdeck.data.repository

import com.gymdeck.data.models.WorkoutRating
import com.gymdeck.data.models.WorkoutSessionEntry
import com.gymdeck.utils.DateUtils
import java.util.*

object WorkoutLog {
    private val sessionHistory = mutableListOf<WorkoutSessionEntry>()
    private val activityByDate = mutableMapOf<String, Boolean>()

    fun logWorkout(workoutId: String, stars: Int, deckSize: Int) {
        val today = DateUtils.getTodayKey()
        activityByDate[today] = true
        sessionHistory.add(
            WorkoutSessionEntry(
                id = workoutId,
                date = today,
                stars = stars,
                deckSize = deckSize
            )
        )
    }

    fun getSessionHistory(): List<WorkoutSessionEntry> = sessionHistory

    fun getTotalStars(): Int = sessionHistory.sumOf { it.stars }

    fun getWeekActivity(): Map<String, Boolean> = activityByDate
}
