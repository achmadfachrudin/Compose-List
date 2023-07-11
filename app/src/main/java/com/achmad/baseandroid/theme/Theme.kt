package com.achmad.baseandroid.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = BaseColor.BlueMedium,
    primaryVariant = BaseColor.BlueDark,
    secondary = BaseColor.GreenMedium,
    onSurface = BaseColor.GreyMedium,
)

private val LightColorPalette = lightColors(
    primary = BaseColor.BlueDark,
    primaryVariant = BaseColor.BlueDark,
    secondary = BaseColor.GreyMedium,
    onSurface = BaseColor.GreyMedium,

    /* Other default colors to override
    background = Color.White,
    surface = Color.White,
    onPrimary = Color.White,
    onSecondary = Color.Black,
    onBackground = Color.Black,
    onSurface = Color.Black,
    */
)

@Composable
fun BaseComposeTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        content = content,
        typography = Typography
    )
}
