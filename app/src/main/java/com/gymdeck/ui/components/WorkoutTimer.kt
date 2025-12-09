package com.gymdeck.ui.components

import android.media.AudioManager
import android.media.AudioManager.*
import android.content.Context
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.delay

@Composable
fun WorkoutTimer(duration: Int, isMuted: Boolean) {
    var timeLeft by remember { mutableStateOf(duration * 60) }
    var isRunning by remember { mutableStateOf(true) }
    val context = LocalContext.current
    val autoMuted = remember { derivedStateOf { isMusicActive(context) } }

    LaunchedEffect(isRunning) {
        if (isRunning) {
            while (timeLeft > 0) {
                delay(1000)
                timeLeft--

                val shouldBeep = !isMuted && !autoMuted.value && (timeLeft in 1..3)
                if (shouldBeep) {
                    println("Beep!") // Replace with actual beep
                }
            }
        }
    }

    Column {
        Text("Time Left: ${timeLeft / 60}:${(timeLeft % 60).toString().padStart(2, '0')}")
        Button(onClick = { isRunning = !isRunning }) {
            Text(if (isRunning) "Pause" else "Resume")
        }
        if (autoMuted.value) {
            Text("🔇 Auto-muted (music detected)", style = MaterialTheme.typography.labelSmall)
        }
    }
}

fun isMusicActive(context: Context): Boolean {
    val audioManager = context.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    return audioManager.isMusicActive
}
