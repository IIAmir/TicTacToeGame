package com.example.tictactoegame.ui.components

import androidx.compose.animation.*
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import com.example.tictactoegame.ui.GameViewModel
import com.example.tictactoegame.ui.theme.ForegroundColor
import com.example.tictactoegame.util.BoardCellValue
import com.example.tictactoegame.util.UserActions

@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class)
@Composable
fun TicTacToeTable(
    gameViewModel: GameViewModel,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .aspectRatio(1f)
            .shadow(
                elevation = 10.dp,
                shape = RoundedCornerShape(20.dp)
            )
            .clip(RoundedCornerShape(20.dp))
            .background(MaterialTheme.colors.ForegroundColor),
        contentAlignment = Alignment.Center
    ) {
        BoardBase()
        LazyVerticalGrid(
            modifier = Modifier
                .fillMaxWidth(0.9f)
                .aspectRatio(1f),
            cells = GridCells.Fixed(3)
        ) {
            gameViewModel.boardItems.forEach { (cellNo, boardCelValue) ->
                item {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f)
                            .clickable(
                                interactionSource = MutableInteractionSource(),
                                indication = null
                            ) {
                                gameViewModel.onAction(
                                    UserActions.BoardTapped(cellNo)
                                )
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        AnimatedVisibility(
                            visible = gameViewModel.boardItems[cellNo] != BoardCellValue.NONE,
                            enter = scaleIn(tween(500)),
                            exit = scaleOut(tween(1000))
                        ) {
                            if (boardCelValue == BoardCellValue.CIRCLE) {
                                Circle()
                            } else if (boardCelValue == BoardCellValue.CROSS) {
                                Cross()
                            }
                        }
                    }
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .aspectRatio(1f),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            AnimatedVisibility(
                visible = gameViewModel.state.hasWon,
                enter = fadeIn(tween(2000))
            ) {
                DrawVictoryLine(state = gameViewModel.state)
            }
        }
    }
}