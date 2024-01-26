package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.take_home_apt.presentation.components.TopAppBarComponent
import com.example.take_home_apt.presentation.components.TrackingCard
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding2


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToSearch: () -> Unit,
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
    ){
        TopAppBarComponent()
        Spacer(modifier = Modifier.height(ExtraSmallPadding2))
        TrackingCard()
    }
}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navigateToSearch = {}
    )
}