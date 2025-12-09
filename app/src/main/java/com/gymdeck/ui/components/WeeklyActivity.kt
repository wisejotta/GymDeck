package com.gymdeck.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.gymdeck.data.repository.WorkoutLog
import com.gymdeck.utils.DateUtils

@Composable
fun WeeklyActivity() {
    val weekDays = DateUtils.getLast7Days()
    val activity = WorkoutLog.getWeekActivity()

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        weekDays.forEach { day ->
            val dateKey = resolveDateKey(day)
            val active = activity[dateKey] == true

            Column(horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally) {
                Text(day)
                Box(
                    modifier = Modifier
                        .size(20.dp)
                        .background(
                            if (active) MaterialTheme.colorScheme.primary
                            else Color.LightGray,
                            shape = MaterialTheme.shapes.small
                        )
                )
            }
        }
    }
}

// For now assumes today is Sunday => Mon to Sun order
fun resolveDateKey(dayLabel: String): String {
    // This will be enhanced when we store real timestamps
    return "" // optional placeholder
}
