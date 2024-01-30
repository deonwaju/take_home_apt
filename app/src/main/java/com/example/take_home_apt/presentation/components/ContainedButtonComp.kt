package com.example.take_home_apt.presentation.components

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.take_home_apt.R
import com.example.take_home_apt.utils.Dimens.SmallPadding1
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


enum class BounceState {
    Idle, Pressed
}

@OptIn(DelicateCoroutinesApi::class)
@Composable
fun ContainedButtonComp(
    modifier: Modifier = Modifier,
    text: String = "Continue",
    onClick: (() -> Unit)? = null,
) {

    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isClicked = interactionSource.collectIsPressedAsState().value
    LaunchedEffect(key1 = isClicked) {
        if (isClicked) {
            onClick?.invoke()
        }
    }

    var currentState by remember { mutableStateOf(BounceState.Idle) }

    val elevation by animateDpAsState(
        targetValue = when (currentState) {
            BounceState.Pressed -> 4.dp
            else -> 1.dp
        }
    )

    val scale by animateFloatAsState(
        targetValue = when (currentState) {
            BounceState.Pressed -> 0.95f
            else -> 1f
        }
    )
    val textTitle by remember {
        mutableStateOf(text)
    }

    Button(
        onClick = {
            currentState = BounceState.Pressed
            // Reset state after animation completes
            GlobalScope.launch {
                delay(500)
                currentState = BounceState.Idle
            }
//            onClick?.invoke()
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(SmallPadding1)
            .scale(scale),
        colors = ButtonDefaults.buttonColors(
            contentColor = Color.White,
            containerColor = colorResource(id = R.color.orange)
        ),
        elevation = ButtonDefaults.buttonElevation(
            defaultElevation = 1.dp,
            pressedElevation = 4.dp,
            focusedElevation = 4.dp,
            hoveredElevation = 4.dp,
        ),
        interactionSource = interactionSource
    ) {
        Text(text = textTitle)
    }
}

@Composable
@Preview(showBackground = true)
fun ContainedButtonCompPreview() {
    ContainedButtonComp(text = "sad")
}
