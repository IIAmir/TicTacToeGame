package com.example.tictactoegame.util

sealed class UserActions {
    object PlayAgainButtonClicked : UserActions()
    data class BoardTapped(val cellNo: Int) : UserActions()
}
