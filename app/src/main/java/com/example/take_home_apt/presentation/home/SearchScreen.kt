package com.example.take_home_apt.presentation.home

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen(
    modifier: Modifier = Modifier,
    name: String = "SearchScreen"
) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}