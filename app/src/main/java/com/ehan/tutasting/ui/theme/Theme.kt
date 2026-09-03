package com.ehan.tutasting.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
// import androidx.compose.runtime.SideEffect
// import androidx.compose.ui.graphics.toArgb
// import androidx.compose.ui.platform.LocalContext
// import androidx.compose.ui.platform.LocalView
// import androidx.core.view.WindowCompat

private val TutastingDarkColorScheme = darkColorScheme(
  primary = CrimsonPrimary,
  onPrimary = Color.White,
  primaryContainer = CrimsonDark,
  onPrimaryContainer = GoldAccent,
  secondary = GoldAccent,
  onSecondary = Color.Black,
  secondaryContainer = DarkSurfaceElevated,
  onSecondaryContainer = GoldGlow,
  tertiary = CyanMana,
  onTertiary = Color.Black,
  background = DarkBackground,
  onBackground = TextPrimary,
  surface = DarkSurface,
  onSurface = TextPrimary,
  surfaceVariant = DarkSurfaceElevated,
  onSurfaceVariant = TextSecondary,
  outline = DarkSurfaceBorder
)

@Composable
fun TutastingTheme(
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    //val context = LocalContext.current

    MaterialTheme(
        colorScheme = TutastingDarkColorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}