package com.example.tictactoegame.ui.components

import androidx.compose.runtime.Composable
import com.example.tictactoegame.ui.GameState
import com.example.tictactoegame.util.VictoryType

@Composable
fun DrawVictoryLine(
    state:GameState
) {
    when(state.victoryType){
        VictoryType.HORIZONTAL_TOP -> WinHorizontalLineTop()
        VictoryType.HORIZONTAL_CENTER -> WinHorizontalLineCenter()
        VictoryType.HORIZONTAL_BOTTOM -> WinHorizontalLineBottom()
        VictoryType.VERTICAL_START -> WinVerticalLineStart()
        VictoryType.VERTICAL_CENTER -> WinVerticalLineCenter()
        VictoryType.VERTICAL_END -> WinVerticalLineEnd()
        VictoryType.DIAGONAL_START -> WinDiagonalLineStart()
        VictoryType.DIAGONAL_END -> WinDiagonalLineEnd()
        VictoryType.NONE -> {}
    }
}