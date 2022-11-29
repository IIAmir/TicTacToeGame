package com.example.tictactoegame.ui.theme

import androidx.compose.material.Colors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple200 = Color(0xFFBB86FC)
val Purple500 = Color(0xFF6200EE)
val Purple700 = Color(0xFF3700B3)
val Teal200 = Color(0xFF03DAC5)

val DarkGray = Color(0xFF141414)

val Aqua = Color(0xFF04D4F0)
val GreenishYellow = Color(0xFFA8C920)
val GrayBackground = Color(0xFFF5F7F6)
val BlueCustom = Color(0xFF3871DF)

val Colors.BackgroundColor: Color
    @Composable
    get() = if (isLight) GrayBackground else Color.Black

val Colors.ForegroundColor: Color
    @Composable
    get() = if (isLight) Color.White else DarkGray

val Colors.TextColor: Color
    @Composable
    get() = if (isLight) Color.Black else Color.White