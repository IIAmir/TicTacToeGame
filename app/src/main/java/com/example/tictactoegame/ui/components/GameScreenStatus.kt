package com.example.tictactoegame.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tictactoegame.ui.GameViewModel
import com.example.tictactoegame.ui.theme.BlueCustom
import com.example.tictactoegame.ui.theme.TextColor
import com.example.tictactoegame.util.Constants.PLAY_AGAIN
import com.example.tictactoegame.util.UserActions

@Composable
fun GameScreenStatus(gameViewModel: GameViewModel) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = gameViewModel.state.hintText,
            fontSize = 24.sp,
            fontStyle = FontStyle.Italic,
            color = MaterialTheme.colors.TextColor
        )
        Button(
            onClick = {
                gameViewModel.onAction(
                    UserActions.PlayAgainButtonClicked
                )
            },
            shape = RoundedCornerShape(5.dp),
            elevation = ButtonDefaults.elevation(5.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = BlueCustom,
                contentColor = Color.White
            )
        ) {
            Text(
                text = PLAY_AGAIN,
                fontSize = 16.sp
            )
        }
    }
}