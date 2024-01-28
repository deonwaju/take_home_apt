package com.example.take_home_apt.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.utils.Dimens.SmallPadding1

@Composable
fun ContainedButtonComp(
    modifier: Modifier = Modifier,
    text: String,
    onClick: (() -> Unit)? = null
) {
    val textTitle by remember {
        mutableStateOf(text)
    }
    Button(
        onClick = {
            onClick?.invoke()
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(SmallPadding1),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = Color(0xFFFFA500)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 1.dp,
            pressedElevation = 4.dp,
            focusedElevation = 4.dp,
            hoveredElevation = 4.dp,
        )
    ) {
        Text(textTitle)
    }
}