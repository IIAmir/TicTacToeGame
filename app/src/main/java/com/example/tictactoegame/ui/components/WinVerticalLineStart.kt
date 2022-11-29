package com.example.tictactoegame.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.dp

@Composable
fun WinVerticalLineStart() {
    Canvas(
        modifier = Modifier.size(300.dp)
    ) {
        drawLine(
            color = Color.Red,
            strokeWidth = 10f,
            cap = StrokeCap.Round,
            start = Offset(x = size.width * 1 / 6, y = 0f),
            end = Offset(x = size.width * 1 / 6, y = size.height)
        )
    }
}