package com.gymdeck.utils

import java.text.SimpleDateFormat
import java.util.*

object DateUtils {
    fun getLast7Days(): List<String> {
        val sdf = SimpleDateFormat("EEE", Locale.getDefault())
        val calendar = Calendar.getInstance()
        return (0..6).map {
            val label = sdf.format(calendar.time)
            calendar.add(Calendar.DAY_OF_YEAR, -1)
            label
        }.reversed()
    }

    fun getTodayKey(): String {
        val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        return sdf.format(Date())
    }
}
