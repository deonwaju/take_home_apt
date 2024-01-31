package com.example.take_home_apt.presentation.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay


@Composable
fun PumpRunningText(modifier: Modifier = Modifier) {
    var fuelLevel by remember { mutableStateOf(0) }
    var isPumping by remember { mutableStateOf(true) } // Start pumping automatically

    Spacer(modifier = modifier.height(16.dp))

    LaunchedEffect(isPumping) {
        if (isPumping) {
            for (i in 1370..1439) {
                fuelLevel = i
                delay(30)
            }
            isPumping = false
        }
    }

    // Display the fuel level text
    Text(
        text = "$$fuelLevel",
        style = MaterialTheme.typography.titleLarge,
        fontFamily = FontFamily.SansSerif,
        fontWeight = FontWeight.Light,
        color = Color.Green,
        modifier = modifier
            .alpha(if (isPumping) 1f else 0.5f)
    )

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PumpRunningText()
}