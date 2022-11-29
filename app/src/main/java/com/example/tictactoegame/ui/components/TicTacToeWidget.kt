package com.example.tictactoegame.ui.components

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.tictactoegame.ui.theme.BlueCustom
import com.example.tictactoegame.ui.theme.greatVibesRegular
import com.example.tictactoegame.util.Constants.APP_NAME

@Composable
fun TicTacToeWidget() {
    Text(
        text = APP_NAME,
        fontSize = 50.sp,
        fontFamily = greatVibesRegular,
        fontWeight = FontWeight.Bold,
        color = BlueCustom
    )
}