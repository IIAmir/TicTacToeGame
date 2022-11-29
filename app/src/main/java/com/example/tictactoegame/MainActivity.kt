package com.example.tictactoegame

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.tictactoegame.ui.GameScreen
import com.example.tictactoegame.ui.GameViewModel
import com.example.tictactoegame.ui.theme.TicTacToeGameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TicTacToeGameTheme {
                val viewModel = viewModel<GameViewModel>()
                GameScreen(gameViewModel = viewModel)
            }
        }
    }
}