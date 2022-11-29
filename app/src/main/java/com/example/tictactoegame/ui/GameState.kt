package com.example.tictactoegame.ui

import com.example.tictactoegame.util.BoardCellValue
import com.example.tictactoegame.util.Constants
import com.example.tictactoegame.util.VictoryType

data class GameState(
    val playerCircleCount: Int = 0,
    val playerCrossCount: Int = 0,
    val drawCount: Int = 0,
    val hintText: String = Constants.PLAYER_O_TURN,
    val currentTurn: BoardCellValue = BoardCellValue.CIRCLE,
    val victoryType: VictoryType = VictoryType.NONE,
    val hasWon: Boolean = false,
)
