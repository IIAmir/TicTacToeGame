package com.example.tictactoegame.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import com.example.tictactoegame.ui.GameState
import com.example.tictactoegame.ui.theme.TextColor
import com.example.tictactoegame.util.Constants.DRAW_SCORE
import com.example.tictactoegame.util.Constants.PLAYER_O_SCORE
import com.example.tictactoegame.util.Constants.PLAYER_X_SCORE

@Composable
fun GameScreenTopBar(state: GameState) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = PLAYER_O_SCORE + state.playerCircleCount,
            fontSize = 16.sp,
            color = MaterialTheme.colors.TextColor
        )
        Text(
            text = DRAW_SCORE + state.drawCount,
            fontSize = 16.sp,
            color = MaterialTheme.colors.TextColor
        )
        Text(
            text = PLAYER_X_SCORE + state.playerCrossCount,
            fontSize = 16.sp,
            color = MaterialTheme.colors.TextColor
        )
    }
}