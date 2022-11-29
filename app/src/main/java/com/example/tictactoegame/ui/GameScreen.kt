package com.example.tictactoegame.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tictactoegame.ui.components.GameScreenStatus
import com.example.tictactoegame.ui.components.GameScreenTopBar
import com.example.tictactoegame.ui.components.TicTacToeTable
import com.example.tictactoegame.ui.components.TicTacToeWidget
import com.example.tictactoegame.ui.theme.BackgroundColor
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview(showBackground = true)
@Composable
fun GameScreen(
    gameViewModel: GameViewModel = GameViewModel(),
) {

    val state = gameViewModel.state
    val statusBarColor = rememberSystemUiController()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.BackgroundColor)
            .padding(horizontal = 12.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {

        statusBarColor.setStatusBarColor(MaterialTheme.colors.BackgroundColor)

        GameScreenTopBar(state = state)

        TicTacToeWidget()

        TicTacToeTable(gameViewModel = gameViewModel)

        GameScreenStatus(gameViewModel = gameViewModel)

    }
}