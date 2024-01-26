package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.take_home_apt.presentation.components.TopAppBarComponent
import com.example.take_home_apt.utils.Dimens.MediumPadding1


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    name: String = "HomeScreen",
    navigateToSearch: () -> Unit,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        TopAppBarComponent()
        Spacer(modifier = Modifier.height(MediumPadding1))
    }
}