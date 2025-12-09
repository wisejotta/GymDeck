package com.gymdeck.ui.theme

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorScheme = lightColorScheme(
    primary = BluePrimary,
    secondary = GreenSecondary,
    tertiary = YellowAccent,
    background = LightGrayBackground,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = TextDark
)

@Composable
fun GymDeckTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}

private val DarkColorScheme = darkColorScheme(
    primary = BluePrimary,
    secondary = GreenSecondary,
    tertiary = YellowAccent,
    background = Color.Black,
    onPrimary = Color.White,
    onSecondary = Color.White,
    onBackground = Color.White
)

@Composable
fun GymDeckTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colorScheme = if (darkTheme) DarkColorScheme else LightColorScheme

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
