package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.take_home_apt.presentation.components.AvailableVehiclesList
import com.example.take_home_apt.presentation.components.TopAppBarComp
import com.example.take_home_apt.presentation.components.TrackingCard
import com.example.take_home_apt.utils.Dimens
import com.example.take_home_apt.utils.Dimens.ExtraSmallPadding2


@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navigateToSearch: () -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
    ) {
        item {
            TopAppBarComp(
                readOnly = true,
                onClick = { navigateToSearch() }
            )
            Spacer(modifier = Modifier.height(ExtraSmallPadding2))
            TrackingCard()
            Spacer(modifier = Modifier.height(ExtraSmallPadding2))
            Text(
                text = "Available vehicles",
                style = MaterialTheme.typography.titleLarge,
                fontFamily = FontFamily.SansSerif,
                fontWeight = FontWeight.Bold,
                modifier = modifier.padding(Dimens.SmallPadding1)
            )
            AvailableVehiclesList()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        navigateToSearch = {}
    )
}