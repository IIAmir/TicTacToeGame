package com.example.tictactoegame.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.tictactoegame.util.BoardCellValue
import com.example.tictactoegame.util.Constants.GAME_DRAW
import com.example.tictactoegame.util.Constants.PLAYER_O_TURN
import com.example.tictactoegame.util.Constants.PLAYER_O_WON
import com.example.tictactoegame.util.Constants.PLAYER_X_TURN
import com.example.tictactoegame.util.Constants.PLAYER_X_WON
import com.example.tictactoegame.util.UserActions
import com.example.tictactoegame.util.VictoryType

class GameViewModel : ViewModel() {

    var state by mutableStateOf(GameState())

    val boardItems: MutableMap<Int, BoardCellValue> = mutableMapOf(
        1 to BoardCellValue.NONE,
        2 to BoardCellValue.NONE,
        3 to BoardCellValue.NONE,
        4 to BoardCellValue.NONE,
        5 to BoardCellValue.NONE,
        6 to BoardCellValue.NONE,
        7 to BoardCellValue.NONE,
        8 to BoardCellValue.NONE,
        9 to BoardCellValue.NONE,
    )

    fun onAction(userActions: UserActions) {
        when (userActions) {
            is UserActions.BoardTapped -> {
                addValueToBoard(userActions.cellNo)
            }
            UserActions.PlayAgainButtonClicked -> {
                gameReset()
            }
        }
    }

    private fun gameReset() {
        if (state.currentTurn == BoardCellValue.CIRCLE) {
            boardItems.forEach { (i, _) ->
                boardItems.replace(i, BoardCellValue.NONE)
            }
            state = state.copy(
                hintText = PLAYER_X_TURN,
                currentTurn = BoardCellValue.CROSS,
                victoryType = VictoryType.NONE,
                hasWon = false
            )
        } else {
            boardItems.forEach { (i, _) ->
                boardItems.replace(i, BoardCellValue.NONE)
            }
            state = state.copy(
                hintText = PLAYER_O_TURN,
                currentTurn = BoardCellValue.CIRCLE,
                victoryType = VictoryType.NONE,
                hasWon = false
            )
        }
    }

    private fun addValueToBoard(cellNo: Int) {
        if (boardItems[cellNo] != BoardCellValue.NONE) {
            return
        }
        if (state.currentTurn == BoardCellValue.CIRCLE) {
            boardItems[cellNo] = BoardCellValue.CIRCLE
            if (checkForVictory(BoardCellValue.CIRCLE)) {
                state = state.copy(
                    hintText = PLAYER_O_WON,
                    playerCircleCount = state.playerCircleCount + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            } else if (hasBoardFull()) {
                state = state.copy(
                    hintText = GAME_DRAW,
                    drawCount = state.drawCount + 1
                )
            } else {
                state = state.copy(
                    hintText = PLAYER_X_TURN,
                    currentTurn = BoardCellValue.CROSS
                )
            }
        } else if (state.currentTurn == BoardCellValue.CROSS) {
            boardItems[cellNo] = BoardCellValue.CROSS
            if (checkForVictory(BoardCellValue.CROSS)) {
                state = state.copy(
                    hintText = PLAYER_X_WON,
                    playerCrossCount = state.playerCrossCount + 1,
                    currentTurn = BoardCellValue.NONE,
                    hasWon = true
                )
            } else if (hasBoardFull()) {
                state = state.copy(
                    hintText = GAME_DRAW,
                    drawCount = state.drawCount + 1
                )
            } else {
                state = state.copy(
                    hintText = PLAYER_O_TURN,
                    currentTurn = BoardCellValue.CIRCLE
                )
            }
        }
    }

    private fun checkForVictory(boardCellValue: BoardCellValue): Boolean {
        when {
            boardItems[1] == boardCellValue && boardItems[2] == boardCellValue && boardItems[3] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL_TOP)
                return true
            }
            boardItems[4] == boardCellValue && boardItems[5] == boardCellValue && boardItems[6] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL_CENTER)
                return true
            }
            boardItems[7] == boardCellValue && boardItems[8] == boardCellValue && boardItems[9] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.HORIZONTAL_BOTTOM)
                return true
            }
            boardItems[1] == boardCellValue && boardItems[4] == boardCellValue && boardItems[7] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.VERTICAL_START)
                return true
            }
            boardItems[2] == boardCellValue && boardItems[5] == boardCellValue && boardItems[8] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.VERTICAL_CENTER)
                return true
            }
            boardItems[3] == boardCellValue && boardItems[6] == boardCellValue && boardItems[9] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.VERTICAL_END)
                return true
            }
            boardItems[1] == boardCellValue && boardItems[5] == boardCellValue && boardItems[9] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.DIAGONAL_START)
                return true
            }
            boardItems[3] == boardCellValue && boardItems[5] == boardCellValue && boardItems[7] == boardCellValue -> {
                state = state.copy(victoryType = VictoryType.DIAGONAL_END)
                return true
            }
            else -> return false
        }
    }

    private fun hasBoardFull(): Boolean {
        if (boardItems.containsValue(BoardCellValue.NONE)) return false
        return true
    }
}