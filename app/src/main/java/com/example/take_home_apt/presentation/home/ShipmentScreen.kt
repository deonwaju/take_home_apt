package com.example.take_home_apt.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.TabRowDefaults
import androidx.compose.material3.TabRowDefaults.tabIndicatorOffset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ShipmentScreen(
    modifier: Modifier = Modifier,
    name: String = "ShipmentScreen"
) {
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        TabScreen()

    }
}

@Composable
fun TabScreen(modifier: Modifier = Modifier) {
    var tabIndex by remember { mutableIntStateOf(0) }

    val tabs = listOf("All", "Completed", "In progress", "Pending")

    TabRow(
        selectedTabIndex = tabIndex,
        modifier = modifier
            .background(MaterialTheme.colorScheme.primary),
        indicator = { tabPositions ->

            TabRowDefaults.Indicator(
                color = Color(0xFFFFA500),
                modifier = Modifier.tabIndicatorOffset(tabPositions[tabIndex])
            )
        }
    ) {
        tabs.forEachIndexed { index, title ->
            Tab(
                text = {
                    Text(
                        text = title,
                        color = if (tabIndex == index) Color.White else Color.LightGray
                    )
                },
                selected = tabIndex == index,
                onClick = { tabIndex = index },
                modifier = modifier
                    .horizontalScroll(rememberScrollState())
                    .background(MaterialTheme.colorScheme.primary)
            )
        }
    }
    when (tabIndex) {
        0 -> AllShipmentScreen()
        1 -> CompletedShipmentScreen()
        2 -> InProgressScreen()
        3 -> PendingShipmentScreen()
    }
}

@Composable
fun AllShipmentScreen(modifier: Modifier = Modifier) {

}

@Composable
fun PendingShipmentScreen(modifier: Modifier = Modifier) {

}

@Composable
fun CompletedShipmentScreen(modifier: Modifier = Modifier) {

}

@Composable
fun InProgressScreen(modifier: Modifier = Modifier) {

}


@Composable
@Preview(showBackground = true)
fun PreviewShipmentScreen() {
    ShipmentScreen(

    )
}
