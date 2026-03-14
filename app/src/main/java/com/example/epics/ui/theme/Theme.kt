package com.example.epics.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Green80,
    secondary = GreenGrey80,
    tertiary = Mint80,
    background = DarkBackground,
    surface = Color(0xFF162318),
    primaryContainer = Color(0xFF254B2A),
    secondaryContainer = Color(0xFF2B3E2D),
    onPrimary = Color(0xFF0A2A0E),
    onBackground = Color(0xFFE5F5E3),
    onSurface = Color(0xFFE5F5E3),
    onPrimaryContainer = Color(0xFFCEFFD0),
    onSecondaryContainer = Color(0xFFDCEFD8),
    outline = Color(0xFF87A889),
    outlineVariant = Color(0xFF4F6651)
)

private val LightColorScheme = lightColorScheme(
    primary = Green40,
    secondary = GreenGrey40,
    tertiary = Mint40,
    background = LightBackground,
    surface = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFCDEFCF),
    secondaryContainer = Color(0xFFDCF0DD),
    onPrimary = Color(0xFFFFFFFF),
    onBackground = Color(0xFF122015),
    onSurface = Color(0xFF122015),
    onPrimaryContainer = Color(0xFF113817),
    onSecondaryContainer = Color(0xFF1C3320),
    outline = Color(0xFF6E8B70),
    outlineVariant = Color(0xFFC0D7C2)
)

@Composable
fun EpicsTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}