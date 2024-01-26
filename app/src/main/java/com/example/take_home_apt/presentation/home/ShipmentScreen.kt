package com.example.take_home_apt.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ShipmentScreen(
    modifier: Modifier = Modifier,
    name: String = "ShipmentScreen"
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}